/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.service.impl;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.spring.service.UsersService;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
//@ContextConfiguration(locations = { "/test-jpa-config.xml" })
public class BasicTester {

    private static Logger log = LogManager.getLogger(BasicTester.class);
 
    private UsersService usersService = null;

    public static void main(String[] args) {
        BasicTester bT = new BasicTester();
        bT.doTest();
    }

    
    private void doTest() {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("/test-jpa-config.xml");
         usersService = (UsersService) ctx.getBean("usersService");
        Users u = new Users();
        u.setUserid("zzz dd");
        u.setUsername("zip zimbo");
        try {
            usersService.persist(u);
        } catch (Exception ex) {
           log.error("$$$ "+ex.getMessage());
        }
         


    }
}
