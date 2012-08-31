/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ibatis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Don
 */
public class GeneralDaoFactory {

    private static final String SPRING_XML_FILE = "cvsfeed-spring.xml";
    private static Logger log = LogManager.getLogger(GeneralDaoFactory.class);
    private static ClassPathXmlApplicationContext ctx = null;
    private static CustomerFeedDAO customerFeedDAO = null;

    private GeneralDaoFactory() {
    }

    public static CustomerFeedDAO getCustomerFeedDAO() {
        customerFeedDAO = (CustomerFeedDAO) getCtx().getBean("customerFeedDAO");
        return customerFeedDAO;
    }

    private static AbstractApplicationContext getCtx() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext(GeneralDaoFactory.SPRING_XML_FILE);

        }
        return ctx;
    }
}
