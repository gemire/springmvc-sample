/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author dhenton
 */
public class MuleLauncher {

    private static final String JMS_TEMPLATE_BEAN_NAME = "jmsActiveMQTemplate";
    private static final Logger log = LogManager.getLogger(MuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "test-jms-rollback-config.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

            // talking to jms via mule client
            // DefaultMuleMessage m = new DefaultMuleMessage("bozo", context);
            // context.getClient().dispatch("jms://testConsumerQueue.in",m);
             
            //talking to jms using spring template
            JmsTemplate jmsTemplate = (JmsTemplate) context.getRegistry().get(JMS_TEMPLATE_BEAN_NAME);
            final String outM = "get a bozo";
            jmsTemplate.send(new MessageCreator() {

                @Override
                public Message createMessage(Session sn) throws JMSException {
                    return sn.createTextMessage(outM);
                }
            });

            log.info("finished");

        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }
}
