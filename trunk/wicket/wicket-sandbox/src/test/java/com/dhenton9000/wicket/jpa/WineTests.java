/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Wine;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.dhenton9000.wicket.dao.IWineDao;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class WineTests extends BaseTest {

    private IWineDao service;
    private final static Logger logger = LoggerFactory.getLogger(WineTests.class);
    
    @Before
    public void before() {
        service = getInjector().getInstance(IWineDao.class);
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Wine t = service.findById(new Integer(3));
        assertEquals("MARGERUM SYBARITE", t.getName());
        logger.debug("d "+t.getDescription());

    }

   
}
