/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.simple;

 
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple demonstration of doing a transactional action this can only be 
 * run once as it actually commits to the database
 * @see{com.dhenton9000.jpa.services.UsersServiceImpl}
 * @author dhenton
 */
public class SimpleWrite {
    
     private static final Logger logger = LoggerFactory.getLogger(SimpleWrite.class);
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/test-jpa-config.xml");
    public static void main(String[] args)
    {
        
        SimpleWrite sw = new SimpleWrite();
        try {
            sw.doWrite();
        } catch (Exception ex) {
          logger.error("problem ",ex);
        }
        
    }
    
    /**
     * note that the usersService must be the interface, not the concrete
     * implementation as it is proxied.
     * @throws Exception 
     */
    public void doWrite() throws Exception
    {
        UsersService usersService = (UsersService) context.getBean("usersService");
        Users u = new Users();
        u.setUserid("bozo");
        u.setUsername("bozo K clown");
        usersService.save(u);

    }
}
