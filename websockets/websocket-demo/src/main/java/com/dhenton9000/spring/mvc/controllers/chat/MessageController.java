/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 see https://github.com/theotherian/spring-stomp-chat/tree/master/src/main/java/com/theotherian/chat
 */
package com.dhenton9000.spring.mvc.controllers.chat;

import com.dhenton9000.chat.model.ChatMessage;
import com.dhenton9000.chat.model.RegisteredUser;
import com.dhenton9000.spring.mvc.controllers.HomePageController;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final SimpMessagingTemplate template;
    private static Logger log = LoggerFactory.getLogger(MessageController.class);

    // provided by the websocket namespace in spring-servlet.xml
    @Autowired
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/chat")
    public void greeting(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        chatMessage.setSender(authedSender);
        String recipient = chatMessage.getRecipient();
        if (!authedSender.equals(recipient)) {
            template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
        }

        template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
    }

    @MessageMapping("/registerUser")
    public void registerUser(Message<Object> message,  @Payload RegisteredUser user) 
            throws Exception {
        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        log.debug("authedSender "+authedSender);
        log.debug("userName "+user.getUserName());
    }
    
    
}
