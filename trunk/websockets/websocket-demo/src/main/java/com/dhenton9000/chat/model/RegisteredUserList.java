/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class RegisteredUserList {
    
    private List<RegisteredUser> userList = new ArrayList<>();

    /**
     * @return the userList
     */
    public List<RegisteredUser> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<RegisteredUser> userList) {
        this.userList = userList;
    }
}
