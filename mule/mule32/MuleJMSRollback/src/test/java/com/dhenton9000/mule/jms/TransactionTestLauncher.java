/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jms;

import java.util.HashMap;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author dhenton
 */
public class TransactionTestLauncher {

    private static final Logger log = LogManager.getLogger(TransactionTestLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "transaction-jms-test.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();
            DefaultMuleMessage m = null;
            flowErrorTest(context);
           // flowGoodTest(context);

            log.info("finished");

        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }

    private static void flowGoodTest(MuleContext context) throws MuleException {
        DefaultMuleMessage m = null;
        

        // Flow 1
        // Scenario 1: transactions on primary and secondary////////////////
        // should see 4 messages on the secondary
        // one message consumed on the primary
        String message = "fred";
        sendMessage( message, context);
    
    
    }

    private static void sendMessage(String message, MuleContext context) throws MuleException {
        DefaultMuleMessage m;
       // HashMap prop = new HashMap();
        //prop.put("connector","jms-connector");
        m = new DefaultMuleMessage(message, context);
        context.getClient().dispatch("primaryEndpoint", m,null);
    }

    private static void flowErrorTest(MuleContext context) throws MuleException {
        DefaultMuleMessage m;
        // Flow 1
        //Scenario 1: transactions on primary and secondary////////////////
        // error thrown in second step after splitter
        // talking to jms via mule client bozo is which errors before
        // exiting JmsTransactionsTestComponent
        // DefaultMuleMessage m = new DefaultMuleMessage("bozo1", context);
        // context.getClient().dispatch("jms://transactionPrimary.in",m);
        // this errors in TransactionErrorTester which is after
        // JmsTransactionsTestComponent exits
        // when done:
        // nothing on primary
        // message on DLQ.primary
        // nothing on secondary or DLQ.secondary
        
       
       // sendMessage("bozo1", context);
        //////////////////////////////////////////////////////////////////
        //Flow 1
        //Scenario 2: transactions on primary and secondary////////////////
        // error thrown in second step after splitter
        // talking to jms via mule client bozo is which errors before
        // exiting JmsTransactionsTestComponent
        // this errors in TransactionErrorTester which is after
        // JmsTransactionsTestComponent exits

        // when done:
        // nothing on primary
        // message on DLQ.primary
        // nothing on secondary or DLQ.secondary
        // m = new DefaultMuleMessage("bozo2", context);
        // context.getClient().dispatch("jms://transactionPrimary.in",m);
       sendMessage("bozo2", context);
 

        //////////////////////////////////////////////////////////////////
        
    }
}
