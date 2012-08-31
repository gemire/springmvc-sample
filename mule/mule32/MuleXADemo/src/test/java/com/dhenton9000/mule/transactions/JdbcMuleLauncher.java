/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.transactions;

import java.util.HashMap;
import java.util.Map;
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
public class JdbcMuleLauncher {

    private static final Logger log = LogManager.getLogger(JdbcMuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "jdbc-jms-mule-config.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

            //it appears that the type of exception does not have 
            //any affect on going to the DLQ all exceptions go there
            
            LocalMuleClient localClient = context.getClient();
            MuleMessage mm = null;
            mm = new DefaultMuleMessage("get a bozo", context);
           // Map<String,Object> props = new HashMap<String,Object>();
           // props.put("connector","jmsXAConnector");
          //  localClient.dispatch("jms://jdbc-input?connector=jmsXAConnector", mm );
   
            mm = new DefaultMuleMessage("getb", context);
            localClient.dispatch("jms://jdbc-input", mm);

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