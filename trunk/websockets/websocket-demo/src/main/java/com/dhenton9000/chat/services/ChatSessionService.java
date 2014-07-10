/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

import com.dhenton9000.chat.model.RegisteredUser;

/**
 *
 * @author dhenton
 */
public interface ChatSessionService {

    public void put(String sessionIdObj, RegisteredUser registeredUser);
    public RegisteredUser get(String sessionKey);

    public void invalidate(String sessionIdObj);
}
