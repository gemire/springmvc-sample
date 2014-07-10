/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

import com.dhenton9000.chat.model.RegisteredUser;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class ChatSessionServiceImpl implements ChatSessionService {
     private static Logger log = LoggerFactory.getLogger(ChatSessionServiceImpl.class);
    private final LoadingCache<String, RegisteredUser> activeSessions
            = CacheBuilder.newBuilder().build(new CacheLoader<String, RegisteredUser>() {

                @Override
                public RegisteredUser load(String key) throws Exception {
                    log.debug("registering a user ["+key+"]");
                    return new RegisteredUser(key);
                }

            });

    @Override
    public void put(String sessionIdObj, RegisteredUser registeredUser) {
         activeSessions.put(sessionIdObj, registeredUser);
          
    }
    
     @Override
    public RegisteredUser get(String sessionKey)
    {
        RegisteredUser u = activeSessions.getIfPresent(sessionKey);
        return u;
    }

    @Override
    public void invalidate(String sessionIdObj) {
        activeSessions.invalidate(sessionIdObj);
        
    }
 
}
