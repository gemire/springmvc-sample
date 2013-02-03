/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security;

import com.dhenton9000.jpa.entities.Users;
 

/**
 *
 * @author dhenton
 */
 
public interface AuthenticationService {
    
    /**
     * find the database users object or null if not found
     * @param username
     * @param password
     * @return 
     */
     Users signIn(String username, String password) ;
    
}
