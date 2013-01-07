/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.service.IRestaurantService;
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

    private IRestaurantService service;
    private final static Logger logger = LoggerFactory.getLogger(RestaurantTests.class);

    @Before
    public void before() {
        service = getInjector().getInstance(IRestaurantService.class);
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Restaurant t = service.findById(new Integer(3));
        assertEquals("Subway Subs", t.getName());


    }

    @Test
    public void testDelete() {
        assertNotNull(service);
        Restaurant t = new Restaurant();
        t.setId(new Integer(10));
        service.delete(t);
         


    }
}
