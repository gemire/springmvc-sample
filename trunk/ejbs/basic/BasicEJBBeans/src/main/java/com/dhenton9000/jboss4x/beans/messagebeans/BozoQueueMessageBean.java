package com.dhenton9000.jboss4x.beans.messagebeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/*

*/




@MessageDriven(name = "BozoMessageBean", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/bozoQueue") })

public class BozoQueueMessageBean 
		implements MessageListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2321229579960526016L;
	private static final Logger log = LogManager
			.getLogger(BozoQueueMessageBean.class);

	

	public void onMessage(Message message) {

		log.debug("message sent " + message.toString());
		
	}

	
	
	

}
