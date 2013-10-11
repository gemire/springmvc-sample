/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.jms.listener;

/**
 *
 * @author dhenton
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;

/**
 * This class processes messages in the jms-sender spring file, this
 * is used by the DefaultMessageListenerContainer
 * @author dhenton
 */
public class DemoMessageListener implements SessionAwareMessageListener {
 private static Logger log = LogManager.getLogger(DemoMessageListener.class);
    public void onMessage(Message msg,Session ss) {

        if (msg instanceof TextMessage) {
            try {
                log.debug("Received msg asynchronously: " + ((TextMessage) msg).getText());

            } catch (JMSException e) {
               log.error("JMS error in listener "+e.getMessage());
            }

        } else {

            throw new RuntimeException("This message should be of type TextMessage");
        }
    }
}