package com.dhenton9000.worker;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SampleMDP implements MessageListener {
	private static Logger log = LogManager.getLogger(SampleMDP.class);
	public void onMessage(Message message) {
		TextMessage m = (TextMessage) message;
		processMessage(m);
	}
	/**
	 * @param message
	 */
	private void processMessage(TextMessage m) {
		String i = null;
		 
		if (m != null)
		{
			try {
				i = m.getText();
			} catch (JMSException e) {
				log.error("Jms problem "+e.getMessage());
			}
			log.debug("message is "+i);
		}
	}

}
