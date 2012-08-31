/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.lobdemo;

 
import com.dhenton9000.lobdemo.model.LobTable;
import com.dhenton9000.lobdemo.dao.LobTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dhenton
 */
public class SimpleLobWrite {
    
     private static final Logger logger = LoggerFactory.getLogger(SimpleLobWrite.class);
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/lob-jpa-config.xml");
    public static void main(String[] args)
    {
        
        SimpleLobWrite sw = new SimpleLobWrite();
        try {
            sw.doWrite();
        } catch (Exception ex) {
          logger.error("problem ",ex);
        }
        
    }
    
   
    public void doWrite() throws Exception
    {
        LobTableService usersService = (LobTableService) context.getBean("lobTableService");
        LobTable u = new LobTable();
        u.setDescription("get a job");
        u.setLobItem("get another job");
        usersService.save(u);

    }
}
