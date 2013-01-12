/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class RestaurantTests extends BaseTest {

    private IRestaurantDao service;
    private final static Logger logger = LoggerFactory.getLogger(RestaurantTests.class);
    
    @Before
    public void before() {
         
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Restaurant t = service.findById(new Integer(3));
        assertEquals("Subway Subs", t.getName());
        

    }

   
}
