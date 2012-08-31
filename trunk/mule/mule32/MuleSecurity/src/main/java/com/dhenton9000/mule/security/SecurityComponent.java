/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.security.SecurityContext;
import org.apache.log4j.*;


/**
 * This umo processes the results passed in thru the login. It has access 
 * to the credentials via the User object below
 * @author dhenton
 */
public class SecurityComponent implements Callable {

    private static Logger log = LogManager.getLogger(SecurityComponent.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {
        SecurityContext secContext = mec.getSession().getSecurityContext();
        if (secContext != null) {
            MyUserDetails user = (MyUserDetails) secContext.getAuthentication().getPrincipal();
            log.info("@@@@@@@ " + user.getUsername() + " " + user.getPassword());
            log.info("@@@@@@@ " + user.getAuthorities().size());
            log.info("@@@@ UserFullName "+user.getUserFullName());


        } else {
            log.info("sec is null");

        }

        log.info("sec " + mec.getMessage().getClass().getName());
        log.info("sec " + mec.getMessageAsString());
        return "get a job " + mec.getMessageAsString();
    }
}
