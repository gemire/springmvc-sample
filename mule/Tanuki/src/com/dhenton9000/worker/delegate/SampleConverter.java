package com.dhenton9000.worker.delegate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class SampleConverter implements MessageConverter {

	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		 
		if (message instanceof TextMessage)
		{
			return ((TextMessage) message).getText();
		}
		else
		{
		  throw new MessageConversionException("not a text message");
		}
		 
	}

	public Message toMessage(Object input, Session session) throws JMSException,
			MessageConversionException {
		TextMessage t = session.createTextMessage();
		if (input != null)
		{
			
			t.setText(input.toString());
			return t;
		}
		else
		{
			t.setText("[NULL]");
		}
		
		return null;
	}

}
