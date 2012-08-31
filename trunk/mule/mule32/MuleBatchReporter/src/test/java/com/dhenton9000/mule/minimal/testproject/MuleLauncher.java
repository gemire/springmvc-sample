/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.minimal.testproject;
import java.util.HashMap;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
/**
 *
 * @author dhenton
 */
public class MuleLauncher {

 
    private static final Logger log = LogManager.getLogger(MuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = 
                    new SpringXmlConfigurationBuilder("test-mule-config.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();
            HashMap<String,String> mapItem = new HashMap<String,String>();
            mapItem.put("count","1");
            context.getClient().dispatch("vm://startTest",mapItem, null);
   
            mapItem = new HashMap<String,String>();
            mapItem.put("count","4");
            context.getClient().dispatch("vm://startTest",mapItem, null);
         
            
           // context.stop();
           // context.dispose();
           // System.exit(0);


        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }
}