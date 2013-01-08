/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.service.IApplicationsService;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class ApplicationsTests extends BaseTest {

    private IApplicationsService service;
    private final static Logger logger = LoggerFactory.getLogger(ApplicationsTests.class);

    @Before
    public void beforeTest() {
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Applications app = new Applications();
        app.setId(new Integer(1));
        Applications t = service.get(app);
        assertEquals("ColorParentMatches", t.getApplicationName());

    }

    @Test
    public void testAllApps() {
        List<Applications> t = service.getAllApplications();
        assertEquals(57, t.size());
    }

    @Test
    public void testUserThing() {
        Applications app = new Applications();
        app.setId(new Integer(1));
        List t = service.findUsersForApplications(app);
        assertEquals(23, t.size());


    }
}
