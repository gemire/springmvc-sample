/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security;

import java.io.Serializable;

/**
 *
 * @author dhenton
 */
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

    @Override
    public boolean signIn(String username, String password) {
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (username.equals("wicket") && password.equals("wicket")) {
            return true;
        }
        
        return false;
    }
    
}
