/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

import com.dhenton9000.chat.model.RegisteredUser;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface ChatUsersService {
    
    /**
     * get the registered user if present, otherwise create and store
     * 
     * @param username
     * @return the registered user;
     */
    public RegisteredUser get(String username);
    public List<RegisteredUser> getAllUsers();
}
