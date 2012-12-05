/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/hibernate/DAOHibernateWithRealSessionTest.e.vm.java
 */
package com.dhenton9000.springfuse.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dhenton9000.springfuse.domain.Legacy;
import com.dhenton9000.springfuse.service.LegacyGenerator;
import com.dhenton9000.springfuse.dao.LegacyDao;
import com.dhenton9000.springfuse.util.*;

/**
 * Integration test on LegacyDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class LegacyDaoImplWithRealSessionTest {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(LegacyDaoImplWithRealSessionTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LegacyDao legacyDao;

    @Autowired
    private LegacyGenerator legacyGenerator;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
        ValueGenerator.resetAll();
    }

    @Test
    public void testSaveAndGet() {
        Legacy legacy = legacyGenerator.getLegacy();

        // add it to a Set before saving
        Set<Legacy> set = new HashSet<Legacy>();
        set.add(legacy);

        legacyDao.save(legacy);
        entityManager.flush();

        // reload it from cache and check equality
        Legacy model = new Legacy();
        model.setLegacyPk(legacy.getLegacyPk());
        assertThat(legacy).isEqualTo(legacyDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(legacy).isEqualTo(legacyDao.get(model));
    }
}