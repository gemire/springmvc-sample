/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;

/**
 * This launcher will demonstrate a login to the memory dao. It appears to shut
 * down properly but you should probably check
 * @author dhenton
 */
public class MuleLauncher {

    private static final Logger log = LogManager.getLogger(MuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "security-flow-userdao.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

            LocalMuleClient client = context.getClient();
            MuleMessage mm = new DefaultMuleMessage("bite", context);
            MuleMessage mR = client.send("http://username:password@localhost:9081/services/security", mm);
            log.debug("finished " + mR.getPayloadAsString());
            context.stop();
            context.dispose();
            System.exit(0);
        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
            System.exit(5);
        }

    }
}
