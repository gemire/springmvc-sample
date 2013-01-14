/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.tests;

import com.dhenton9000.jpa.dao.ApplicationsDAO;
import org.slf4j.*;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.services.ApplicationsService;
import com.dhenton9000.jpa.util.ValueGenerator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-jpa-config.xml"})
@Transactional
public class ApplicationsTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationsTest.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    ApplicationsDAO applicationsDAO;
    @Autowired
    ApplicationsService applicationsService;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
        ValueGenerator.resetAll();
    }

    @Test
    public void testInject() {
        assertNotNull(entityManager);
        assertNotNull(applicationsDAO);
        assertNotNull(applicationsService);
    }
    
     @Test 
    public void testSimpleSave()
    {
        logger.debug("get a job");
        Applications a = applicationsService.getNew();
        a.setApplicationName("Fred");
        applicationsService.save(a);
        entityManager.flush();
        entityManager.clear();
       // reload it from cache and check equality
        Applications model = new Applications();
        model.setPrimaryKey(a.getPrimaryKey());
        assertEquals(a,applicationsService.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
         assertEquals(a,applicationsService.get(model));
        
        
        
    }
     
     @Test
     public void testById()
     {
         Applications t = applicationsDAO.findById(new Integer(1));
         assertEquals("ColorParentMatches",t.getApplicationName());
     }
}
