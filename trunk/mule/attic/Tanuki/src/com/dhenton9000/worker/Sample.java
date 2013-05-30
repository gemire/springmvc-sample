package com.dhenton9000.worker;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample {
	private static Logger log = LogManager.getLogger(Sample.class);
	
	
	
	public void doMultipleTest()
	{
		log.debug("beginning doMultipletest()");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"multiple-apache-mq-worker-spring.xml");
		
		
		Thread j = new Thread(new WorkQueueSender());
		
		j.start();
		
		
		
		
		
		
	}
	
	
	
	public void doBestTest()
	{
		log.debug("beginning besttest()");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"best-apache-mq-worker-spring.xml");
	}
	
	public void doMessageListenerWork()
	{
		log.debug("beginning MessageListener()");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"t4-spring.xml");

	}
	
	
	public void doMDPWork()
	{
		log.debug("beginning MDPWork()");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"apache-mq-worker-spring.xml");
	}
	
	
	
	public void doPoisonWork() {
		log.debug("beginning Poison Work()");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"poison-apache-mq-worker-spring.xml");	
	}
	
	public void doSimpleWork() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"apache-mq-worker-spring.xml");
		
		TestWorker testWorker = (TestWorker) ctx.getBean("workerBean");
		
		boolean forever = true;
//		long bTime = System.currentTimeMillis();
//		int counter = 0;
		log.debug("entering loop");
		while (forever) {
//			long tTime = System.currentTimeMillis();
//			if ((tTime - bTime) > 2000) {
//				    counter ++;
//					log.debug("counter is "+counter);
//				    bTime = tTime;
//				
//			} 
			 
			TextMessage m = (TextMessage) 
			testWorker.getJmsWorkQueueTemplate().receive();
			String i = null;
			try {
				if (m != null)
				{
					i = m.getText();
					log.debug("message is "+i);
				}
			} catch (JMSException e) {
				log.error("Jms problem "+e.getMessage());
			}
			
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Sample s = new Sample();
		Hook hook =  s.new Hook(s);
		Runtime.getRuntime().addShutdownHook( hook );
		//s.doPoisonWork();
	//	s.doBestTest();
		s.doMultipleTest();
		//s.doMessageListenerWork();
	}
	
	
	private class Hook extends Thread
	{
		Sample mySample = null;
		public Hook(Sample s)
		{
			mySample = s;
		}
		
		
		public void run() {
		      log.debug( "Running Clean Up..." );
		    }
		
	}

}
