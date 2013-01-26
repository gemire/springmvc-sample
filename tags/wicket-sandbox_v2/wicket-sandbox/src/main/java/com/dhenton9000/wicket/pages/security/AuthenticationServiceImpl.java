/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IUsersDao;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhenton
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

     
    private IUsersDao usersService;
    private final static transient Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public Users signIn(String username, String password) {

        if (getUsersService() == null) {
            throw new RuntimeException("user service null in " + this.getClass().getName());
        }

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }

  
        Users testUser = getUsersService().getUserById(username);
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

    /**
     * @return the usersService
     */
    public IUsersDao getUsersService() {
        return usersService;
    }

    /**
     * @param usersService the usersService to set
     */
    public void setUsersService(IUsersDao usersService) {
        this.usersService = usersService;
    }
}
