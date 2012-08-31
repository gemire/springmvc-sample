/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jms.sandbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dhenton
 */
public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
    private static ClassPathXmlApplicationContext context = null;
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("jms-spring.xml");
        JmsProducer producer =  (JmsProducer) context.getBean("simpleMessageProducer");
        producer.doProduce();
        logger.debug("geta  job");
    }
}
