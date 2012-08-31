package com.dhenton9000.jboss4x.beans.messagebeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/*
 @MessageDriven(mappedName = "jms/counterQueue", activationConfig = {
 @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
 */

@MessageDriven(name = "CounterQueueMessageBean", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/examples/counterQueue") })
public class CounterQueueMessageBean implements MessageListener {
	private static final Logger log = LogManager
			.getLogger(CounterQueueMessageBean.class);
	
	@Autowired
	private String delegateTest;

	public void onMessage(Message message) {

		log.debug("message sent ");
		log.debug("delegate test "+delegateTest);
		if (message instanceof TextMessage) {
			TextMessage textM = (TextMessage) message;
			String info = "not extracted";
			try {
				info = textM.getText();
			} catch (JMSException e) {
				log.error("Jms error when getting text message '"
						+ e.getMessage() + "'");
			}
			log.debug("message received '" + info + "' ");
		} else {
			log.warn("not a text message, was a "
					+ message.getClass().getName());
		}

	}

	public void setDelegateTest(String delegateTest) {
		this.delegateTest = delegateTest;
	}

	public String getDelegateTest() {
		return delegateTest;
	}

}
