/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.transactions;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
/**
 *
 * @author dhenton
 */
public class DLQMuleLauncher {

 
    private static final Logger log = LogManager.getLogger(DLQMuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "dlq-jms-mule-config.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();
            
            LocalMuleClient localClient =context.getClient();
          //  MuleMessage mm = new DefaultMuleMessage("get a job",context);
          //  localClient.dispatch("jms://input", mm);
            MuleMessage mm = new DefaultMuleMessage("get a job, bozo",context);
            localClient.dispatch("jms://input", mm);
           
//           context.stop();
//           context.dispose();
//           System.exit(0);


        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }
}