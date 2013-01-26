/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.minimal.testproject;
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

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "test-mule-ws.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

           
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