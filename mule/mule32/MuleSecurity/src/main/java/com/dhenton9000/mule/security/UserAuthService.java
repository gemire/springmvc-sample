/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.slf4j.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

/**
 *
 * @author dhenton
 */
public class UserAuthService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserAuthService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username");
        }

     
        String password = null;

        if (username.equals("username")) {
           // password = "password";
            password="5f4dcc3b5aa765d61d8327deb882cf99";
            GrantedAuthority[] grantedAuthorities = new GrantedAuthority[1];
            GrantedAuthority authority = new GrantedAuthorityImpl("test");
            grantedAuthorities[0] = authority;
            return new MyUserDetails(username, password, true, true, true, true, grantedAuthorities,"Joe Username");
        } else {
            throw new UsernameNotFoundException("Invalid username");
        }

    }
}
