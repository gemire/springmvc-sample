/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.db.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dhenton
 */
public class Tester {
    private static final Logger logger = LoggerFactory.getLogger(Tester.class);
        
        private static ClassPathXmlApplicationContext context = null;
 
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        logger.debug("start context");
       // InMemoryDBInitializer i = new InMemoryDBInitializer();
        context = new ClassPathXmlApplicationContext("h2-spring.xml"); 
        context.getBean(InMemoryDBInitializer.class);
    }
}
