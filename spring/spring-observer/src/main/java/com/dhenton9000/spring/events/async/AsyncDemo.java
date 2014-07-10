package com.dhenton9000.spring.events.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AsyncDemo {

	public static void main(String args[]) {
		
		ApplicationContext applicationContext = 
                        new ClassPathXmlApplicationContext("classpath:async-context.xml");
		
		
	}
	
}
