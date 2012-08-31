package com.dhenton9000.jms;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class ConnectionExceptionListener implements ExceptionListener {
	private static Logger log = LogManager.getLogger(ConnectionExceptionListener.class);

	public void onException(JMSException ex) {
		
		log.error("ERROR IN ConnectionExceptionListener "+ex.getMessage());
	}

}
