/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ldap.jndi;

/**
 *
 * @author dhenton
 */
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This demonstrates doing a jndi lookup via Spring. The properties file
 * was placed into the JNDI tree with @see{BindDemo}
 * @author dhenton
 */
public class SpringLdapJndiDemo {

    private static final Logger logger = LogManager.getLogger(SpringLdapJndiDemo.class);

    public static void main(String[] args) {


        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("ldap-spring.xml");

        Properties p2 = (Properties) ctx.getBean("propertiesBean");
        logger.debug("message is " + p2.getProperty("wisdom"));

        PropertiesSample ps = (PropertiesSample) ctx.getBean("sampleBean");
        logger.debug("sample says '"+ps.getMessage()+"'");

    }
}
