/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 see https://github.com/theotherian/spring-stomp-chat/tree/master/src/main/java/com/theotherian/chat
 */
package com.dhenton9000.chat.controllers;

import com.dhenton9000.chat.model.ChatMessage;
import com.dhenton9000.chat.model.RegisteredUser;
import com.dhenton9000.chat.model.RegisteredUserList;
import com.dhenton9000.chat.services.ChatUsersService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final SimpMessagingTemplate template;
    public static final String REQUEST_REMOVAL_HEADER = "requestRemoval";
    private final ChatUsersService chatUsersService;
    private static Logger log = LoggerFactory.getLogger(MessageController.class);

    // provided by the websocket namespace in spring-servlet.xml
    @Autowired
    public MessageController(SimpMessagingTemplate template, ChatUsersService chatUsersService) {
        this.template = template;
        this.chatUsersService = chatUsersService;
    }

    /**
     * endpoint for chat messaging
     *
     * @param message
     * @param chatMessage
     * @throws Exception
     */
    @MessageMapping("/chat")
    public void handleChatMessage(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        chatMessage.setSender(authedSender);
        String recipient = chatMessage.getRecipient();
        if (!authedSender.equals(recipient)) {
            // template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
        }

        // template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
    }

    @MessageMapping("/registerUserEndpoint")
    @SendTo("/topic/registerUser")
    public RegisteredUserList registerUser(Message<Object> message, RegisteredUser user,Principal principal)
            throws Exception {
        Boolean requestRemoval = null;
        Map<String, List<String>> nativeHeaders = 
                message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS,Map.class);
        
        List<String> removalHeaders = nativeHeaders.get(REQUEST_REMOVAL_HEADER);
        if (removalHeaders != null)
        {
            requestRemoval =  Boolean.parseBoolean(removalHeaders.get(0));
        }
        else
        {
            throw new RuntimeException("requestRemoval header not present");
        }
            
 
        String authedSender = principal.getName();
        log.debug("authedSender " + authedSender);
        log.debug("userName " + user.getUserName());
        log.debug("request removal header "+requestRemoval);
        
        if (requestRemoval) {
            chatUsersService.remove(user.getUserName());
        } else {
            chatUsersService.get(user.getUserName());

        }
        RegisteredUserList userList = chatUsersService.getAllUsers();
        log.debug("in register User "+userList.getUserList());
        return userList ;

    }
    

}
