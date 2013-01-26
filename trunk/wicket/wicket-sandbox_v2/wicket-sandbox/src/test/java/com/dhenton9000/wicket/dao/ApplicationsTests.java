/*
 * These are tests the require the SEC database be running in derby
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.service.IApplicationsService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-wicket-jpa-config.xml"})
@Transactional
public class ApplicationsTests extends BaseTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    IApplicationsDao applicationsDao;
    @Autowired
    private IApplicationsService service;
    private final static Logger logger = LoggerFactory.getLogger(ApplicationsTests.class);

    @Before
    public void beforeTest() {
    }

    @Test
    public void testInject() {
        assertNotNull(entityManager);
        assertNotNull(applicationsDao);
        assertEquals(47, applicationsDao.getAllApplications().size());
        assertNotNull(service);
    }

    @Test
    public void testDataStuff() {
        assertNotNull(service);
        Applications app = new Applications();
        app.setId(new Integer(1));
        Applications t = service.get(app);
        assertEquals("ColorParent", t.getApplicationName());

    }

    @Test
    public void testAllApps() {
        List<Applications> t = service.getAllApplications();
        assertEquals(47, t.size());
    }

    @Test
    public void testUserThing() {
        Applications app = new Applications();
        app.setId(new Integer(1));
        List t = service.findUsersForApplications(app);
        assertEquals(22, t.size());


    }
}
