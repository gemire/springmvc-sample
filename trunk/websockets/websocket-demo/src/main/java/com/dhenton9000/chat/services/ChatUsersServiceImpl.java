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
import java.util.ArrayList;
import java.util.List;

public class ChatUsersServiceImpl implements ChatUsersService {

    private final LoadingCache<String, RegisteredUser> activeUsers
            = CacheBuilder.newBuilder().build(new CacheLoader<String, RegisteredUser>() {

                @Override
                public RegisteredUser load(String key) throws Exception {
                    return new RegisteredUser(key);
                }

            });
 
    @Override
    public RegisteredUser get(String username) {
        return activeUsers.getUnchecked(username);
    }

    @Override
    public List<RegisteredUser> getAllUsers() {
        ArrayList<RegisteredUser> users = new ArrayList<>();
        for (String user : activeUsers.asMap().keySet()) {
            users.add(activeUsers.getUnchecked(user));

        }
        return users;
    }

}
