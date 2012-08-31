/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jersey;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;

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
//com.sun.jersey.config.property.packages
//The ResourceConfig instance does not contain any root resource classes            
            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "test-mule-config.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();
            final MuleClient muleClient = context.getClient();
            MuleMessage dM = new DefaultMuleMessage("zed", context);
            Object z = muleClient.send("http://localhost:8500/sayhello/fred", dM);
            log.info("$$$$$$$$$$$$$$$$$$$$$this is the result " + z);
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