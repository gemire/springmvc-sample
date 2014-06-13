/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.auctions.auth;

import com.dhenton9000.auctions.model.Bidders;
import com.dhenton9000.auctions.service.AuctionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author dhenton
 */
public class BiddersAuthService implements UserDetailsService {

    @Autowired
    private AuctionService auctionsService;

    protected static Logger logger = LoggerFactory.getLogger(BiddersAuthService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails;
        Bidders bidder;

        bidder = auctionsService.getBidderByUserName(username);
        userDetails = new User(
                bidder.getUserName(),
                bidder.getPassword().toLowerCase(),
                true,
                true,
                true,
                true,
                getAuthorities(0));
        return userDetails;

    }

    /**
     * Retrieves the correct ROLE type depending on the access level, where
     * access level is an Integer. Basically, this interprets the access value
     * whether it's for a regular user or admin. the value will be derived from
     * the Bidders POJO via the database 1, regular 2, admin
     *
     * @param access an integer value representing the access of the user
     * @return collection of granted authorities
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {
        // Create a list of grants for this user
        List<GrantedAuthority> authList = new ArrayList<>(2);

                        // All users are granted with ROLE_USER access
        // Therefore this user gets a ROLE_USER by default
        logger.debug("Grant ROLE_USER to this user");
        authList.add(new SimpleGrantedAuthority("ROLE_BIDDER"));

        // Check if this user has admin access 
        // We interpret Integer(1) as an admin user
        if (access.compareTo(1) == 0) {
            // User has admin access
            logger.debug("Grant ROLE_ADMIN to this user");
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

                        // Return list of granted authorities
        //return authList;
        // for now don't return anything
        //TODO add roles management
        return null;
    }

}
