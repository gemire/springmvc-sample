/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jms;

import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.client.MuleClient;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

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
            DefaultMuleMessage mm = new DefaultMuleMessage("fred", context);
            //  testClient.dispatch("jms://testProcess.in", mm);

            for (int i = 0; i < 4; i++) {
                testClient.dispatch("jms://testProcess.reply", mm);
                log.debug("hit");
            }

            Object zz = testClient.request("jms://testProcess.reply", 1000);


            /*
             MuleMessage reply = testClient.request("jms://testProcess.reply", 1000);
             log.debug("finished " + reply.getPayloadAsString());
             Set<String> inboundProps = reply.getPropertyNames(PropertyScope.INBOUND);
             Iterator<String> in_iter = inboundProps.iterator();
             while (in_iter.hasNext()) {
             String i = in_iter.next();
             log.debug("In " + i + " " + reply.getProperty(i, PropertyScope.INBOUND));

             }


             Set<String> outboundProps = reply.getPropertyNames(PropertyScope.OUTBOUND);
             Iterator<String> out_iter = outboundProps.iterator();
             while (out_iter.hasNext()) {
             String i = out_iter.next();
             log.debug("Out " + i + " " + reply.getProperty(i, PropertyScope.OUTBOUND));
             }
             */

        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }
}
