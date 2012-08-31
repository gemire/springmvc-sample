/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jms.sandbox;

import java.util.concurrent.atomic.AtomicInteger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class JmsListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsListener.class);
    private AtomicInteger counter = null;

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }

    /**
     * Implementation of
     * <code>MessageListener</code>.
     */
    public void onMessage(Message message) {
        try {
            int messageCount = 0;
            messageCount = message.getIntProperty(JmsProducer.MESSAGE_COUNT_PROPERTY);


            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                String msg = tm.getText();
                int counterVal = counter.incrementAndGet();
                Object[] infoArray = {msg, messageCount, counterVal};
                logger.info("Processed message '{}'.  value={}, counter={}", infoArray);
            } else {
                logger.info("message was of type " + message.getClass().getName());
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
}