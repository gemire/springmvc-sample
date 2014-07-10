package com.dhenton9000.spring.events.observer;

 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObserverDemo {

	public static void main(String args[]) {
		
		ApplicationContext applicationContext = 
                        new ClassPathXmlApplicationContext("classpath:observer-context.xml");
		
		
	}
	
}
