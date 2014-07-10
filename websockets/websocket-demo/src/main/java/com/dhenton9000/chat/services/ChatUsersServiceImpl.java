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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatUsersServiceImpl implements ChatUsersService {

    private static Logger log = LoggerFactory.getLogger(ChatUsersServiceImpl.class);
    private final LoadingCache<String, RegisteredUser> activeUsers
            = CacheBuilder.newBuilder().build(new CacheLoader<String, RegisteredUser>() {

                @Override
                public RegisteredUser load(String key) throws Exception {
                    log.debug("registering a user ["+key+"]");
                    return new RegisteredUser(key);
                }

            });
 
    @Override
    public RegisteredUser get(String key) {
        log.debug("get "+key);
        
        return activeUsers.getUnchecked(key);
    }

    @Override
    public RegisteredUserList  getAllUsers() {
        RegisteredUserList  usersList = new RegisteredUserList();
        for (String user : activeUsers.asMap().keySet()) {
            usersList.getUserList().add(activeUsers.getUnchecked(user));

        }
         
        return usersList;
    }
    
    @Override
    public long getUserCount()
    {
        return activeUsers.size();
         
    }

    @Override
    public void remove(String key) {
         log.debug("remove "+key);
         activeUsers.invalidate(key);
    }

}
