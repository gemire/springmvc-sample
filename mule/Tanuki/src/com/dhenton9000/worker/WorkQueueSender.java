package com.dhenton9000.worker;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class WorkQueueSender implements Runnable {
	private static Logger log = LogManager.getLogger(Sample.class);
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
	"multiple-apache-mq-worker-spring.xml");
	public void run() {
		 JmsTemplate jTemplate = (JmsTemplate) ctx.getBean("workQueueTemplateBean");
		 
		 for (int i=0;i< 300;i++)
		 {
			 
			 String info = "Message "+i+" -- ";
			 if (i == 35)
			 {
				 info = info +" DEAD ";
			 }
			TMessageCreator messageCreator = new TMessageCreator(info);
			jTemplate.send(messageCreator);
			 
			 
			 
		 }
		 
		 
		 
		 

	}

	
	public class TMessageCreator implements MessageCreator
	{
		
		String info = null;
		public TMessageCreator(String i) {
			info = i;
		}

		public Message createMessage(Session session) throws JMSException {
			 TextMessage t = session.createTextMessage(info);
			 return t;
		}
		
	}
	
	
	
	
}
