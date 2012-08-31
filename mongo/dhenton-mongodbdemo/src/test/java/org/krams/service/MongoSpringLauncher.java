/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krams.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Don
 */
public class MongoSpringLauncher {

    private static ClassPathXmlApplicationContext context = null;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("spring-data.xml");
        InitMongoService initService = 
                (InitMongoService) context.getBean("initService");
        
        initService.init();
    }
}
