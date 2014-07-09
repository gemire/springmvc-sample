/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.model;

import java.util.Objects;

/**
 *
 * @author dhenton
 */
public class RegisteredUser {
    
    
    private String userName;
    

    public RegisteredUser(String u)
    {
        userName = u;
    }
    public RegisteredUser()
    {
        
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisteredUser other = (RegisteredUser) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" + "userName=" + userName + '}';
    }

    
    
}
