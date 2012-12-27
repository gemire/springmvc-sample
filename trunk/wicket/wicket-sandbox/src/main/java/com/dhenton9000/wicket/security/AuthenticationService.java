/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security;

/**
 *
 * @author dhenton
 */
public interface AuthenticationService {
    
     boolean signIn(String username, String password) ;
    
}
