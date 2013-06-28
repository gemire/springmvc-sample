package com.dhenton9000.demo.threads.sheep;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhenton9000.demo.threads.sheep.producer.SheepProducer;

public class MainSheepDemo {

	/**
	 * @param args
	 */
	
	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static Logger log = Logger.getLogger(MainSheepDemo.class);
	
	
	public static void main(String[] args) {
		
		log.debug("start");
		SheepProducer producer = (SheepProducer) ctx.getBean("sheepProducer");
		producer.start();

	}

}
