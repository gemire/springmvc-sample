/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author dhenton
 */
public class ApplicationsTests extends BaseTest {

    private IApplicationsDao service;

    @Before
    public void before() {
        service = getInjector().getInstance(IApplicationsDao.class);
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Applications app = new Applications();
        app.setId(new Integer(1));
        Applications t = service.get(app);
        assertEquals("ColorParentMatches", t.getApplicationName());

    }
}
