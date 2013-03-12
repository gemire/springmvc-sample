/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jms;

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
			
			SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
			"test-jms-config.xml");

			MuleContext context = muleContextFactory.createMuleContext(configBuilder);
			context.start();
			
                        MuleClient testClient = context.getClient();
                        DefaultMuleMessage mm = new DefaultMuleMessage("fred",context);
                        testClient.dispatch("jms://testProcess.in",mm);
                        MuleMessage reply = testClient.request("jms://testProcess.reply",1000);
			log.debug("finished "+reply.getPayloadAsString());

		} catch (Exception e) {
			String eInfo = "Error Class: " + e.getClass().getName() + "\n"
					+ "message: " + e.getMessage();
			log.error(eInfo);
		}

	}
}
