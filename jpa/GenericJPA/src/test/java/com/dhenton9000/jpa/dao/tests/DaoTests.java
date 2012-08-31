/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.tests;

import com.dhenton9000.jpa.dao.UsersDAO;
import org.slf4j.*;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.services.UsersService;
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
public class DaoTests {

    private static final Logger logger = LoggerFactory.getLogger(DaoTests.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UsersDAO usersDAO;
    @Autowired
    UsersService usersService;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
        ValueGenerator.resetAll();
    }

    @Test
    public void testInject() {
        assertNotNull(entityManager);
        assertNotNull(usersDAO);
        assertNotNull(usersService);
    }
    
    @Test 
    public void testSimpleSave()
    {
        logger.debug("get a job");
        Users u = new Users();
        u.setUserid("bozo");
        u.setUsername("bozo K clown");
        usersDAO.save(u);
        entityManager.flush();
        entityManager.clear();
       // reload it from cache and check equality
        Users model = new Users();
        model.setPrimaryKey(u.getPrimaryKey());
        assertEquals(u,usersDAO.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
         assertEquals(u,usersDAO.get(model));
        
        
        
    }
     @Test 
    public void testSimpleService()
    {
        logger.debug("get a job");
        Users u = new Users();
        u.setUserid("bozo");
        u.setUsername("bozo K clown");
        usersService.save(u);
        entityManager.flush();
        entityManager.clear();
       // reload it from cache and check equality
        Users model = new Users();
        model.setPrimaryKey(u.getPrimaryKey());
        assertEquals(u, usersService.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
         assertEquals(u, usersService.get(model));
        
        
        
    }
}
