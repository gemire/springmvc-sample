/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.chat.services;

import com.dhenton9000.chat.model.RegisteredUser;
import com.dhenton9000.chat.model.RegisteredUserList;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 *
 * @author dhenton
 */
@Service
public class ChatSessionServiceImpl implements ChatSessionService {

    private static Logger log = LoggerFactory.getLogger(ChatSessionServiceImpl.class);
    @Autowired
    private  SimpMessageSendingOperations messagingTemplate;

    
    public ChatSessionServiceImpl(){
    }

    private final LoadingCache<String, RegisteredUser> activeSessions
            = CacheBuilder.newBuilder().build(new CacheLoader<String, RegisteredUser>() {

                @Override
                public RegisteredUser load(String key) throws Exception {
                    log.debug("registering a user [" + key + "]");
                    return new RegisteredUser(key);
                }

            });

    @Override
    public void put(String sessionIdObj, RegisteredUser registeredUser) {
        log.debug("put " + sessionIdObj + " " + registeredUser);
        activeSessions.put(sessionIdObj, registeredUser);
      //  sendNewUserList();

    }

    @Override
    public RegisteredUser get(String sessionKey) {
        RegisteredUser u = activeSessions.getIfPresent(sessionKey);
        return u;
    }

    @Override
    public void invalidate(String sessionIdObj) {
        log.debug("invalidate " + sessionIdObj);
        activeSessions.invalidate(sessionIdObj);
      //  sendNewUserList();

    }

    public void sendNewUserList() {
        RegisteredUserList  usersList = new RegisteredUserList(); 
        for (String session : activeSessions.asMap().keySet()) {
            RegisteredUser r = activeSessions.getIfPresent(session);
            if (r != null)
                usersList.getUserList().add(r);

        }
        log.debug("sendNew User List "+usersList.getUserList());
        
        Map<String, Object> map = new HashMap<>();
        map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        this.messagingTemplate.convertAndSend("/topic/registerUser",  usersList, map);

    }

}
