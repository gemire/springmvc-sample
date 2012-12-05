/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.tests;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.services.UsersService;
import com.dhenton9000.jpa.util.ValueGenerator;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-jpa-config.xml"})
@Transactional
public class HydrateTest {

    private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UsersService usersService;
    @Autowired
    ApplicationContext context;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
        ValueGenerator.resetAll();
    }

    @Test
    public void applicationContextFound() {
        assertNotNull(context);
    }

    @Test
    public void testSimpleHydrate() {
        Users u = usersService.getByPrimaryKey("gaw");
        assertNotNull(u);
        Set<Groups> groups = u.getGroupsSet();
        assertNotNull(groups);
        String testGroups = "";
        Iterator<Groups> ig = groups.iterator();
        while (ig.hasNext()) {
            Groups g = ig.next();
            testGroups += g.getGroupName();
        }

        assertTrue(testGroups.indexOf("PowerUsers") > -1);
    }

    @Test
    public void testGraphWalk() {
        Users u = usersService.getByPrimaryKey("gaw");
        assertNotNull(u);
        Set<Groups> groups = u.getGroupsSet();
        assertNotNull(groups);
        Iterator<Groups> ig = groups.iterator();
        while (ig.hasNext()) {
            Groups g = ig.next();
            logger.debug("Group: " + g.getGroupName());
            Set<Applications> apps = g.getApplicationsSet();
            Iterator<Applications> appIter = apps.iterator();
            while (appIter.hasNext()) {
                Applications a = appIter.next();
                logger.debug("\t" + a.getApplicationName());
            }




        }


    }
}
