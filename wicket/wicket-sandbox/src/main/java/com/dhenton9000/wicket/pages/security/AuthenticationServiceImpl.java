/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IUsersDao;
import com.google.inject.Inject;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

    @Inject
    private IUsersDao usersService;
    private final static transient Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public Users signIn(String username, String password) {

        if (usersService == null) {
            throw new RuntimeException("user service null in " + this.getClass().getName());
        }

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }

  
        Users testUser = usersService.getUserById(username);
        logger.debug("testing user ");
        if (testUser != null) {
            String passwordTemp = testUser.getPassword();
            logger.debug("found password of '" + passwordTemp + "' enterd pasword is '" + password + "'");
            if (password.equals(passwordTemp)) {
                return testUser;

            }

        }

        return null;
    }
}
