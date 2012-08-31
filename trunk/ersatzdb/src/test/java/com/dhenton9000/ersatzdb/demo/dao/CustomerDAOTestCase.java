/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb.demo.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.dhenton9000.ersatzdb.vo.Customers;
import java.util.List;

/**
 *
 */
public class CustomerDAOTestCase {

    private static ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("ersatz-spring.xml");
    private static Logger log = LogManager.getLogger(CustomerDAOTestCase.class);
    private static CustomerDAO custGen = null;

    @BeforeClass
    public static void beforeClass() {

        custGen = (CustomerDAO) ctx.getBean("mockCustomerDAO");
    }

    @Before
    public void before() {
    }

    @Test
    public void testDAO() {

        assertEquals(3, custGen.findAll().size());
    }

    @Test
    public void getSingleItem() {
        Customers c = custGen.getCustomerById(256);
        assertEquals(256, c.getCustomerNumber());
        assertEquals("<Zumwalt>", c.getContactLastName());
    }

    @Test
    public void getOther() {
        Customers c = custGen.getCustomerById(666);
        assertEquals(666, c.getCustomerNumber());
        assertEquals("Nelson", c.getContactLastName());
    }
}
