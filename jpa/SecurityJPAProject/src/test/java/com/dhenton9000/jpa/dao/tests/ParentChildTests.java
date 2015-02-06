/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.tests;

import com.dhenton9000.jpa.dao.ChildDao;
import com.dhenton9000.jpa.dao.ParentDao;
import com.dhenton9000.jpa.entities.Child;
import com.dhenton9000.jpa.entities.Parent;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.assertEquals;
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
@ContextConfiguration(locations = {"classpath*:test-jpa-config-ps.xml"})
@Transactional
public class ParentChildTests {

    private static final Logger logger = LoggerFactory.getLogger(ParentChildTests.class);
    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    ParentDao parentDAO;
    @Autowired
    ChildDao childDAO;

    @Before
    public void onSetUp() throws Exception {

    }

    @Test
    public void testSimpleSave() {
        
        Parent p = new Parent();
        p.setName("bonzo");
        Child c = new Child();
        c.setName("bonzo child");
        HashSet<Child> children = new HashSet<Child>();
        children.add(c);
        p.setChildren(children);
        Parent pp = parentDAO.merge(p);
        entityManager.flush();
        entityManager.clear();
         
       pp = parentDAO.get(pp);
       assertEquals(1,pp.getChildren().size());
         
        
    }

}
