package com.dhenton9000.spring.mvc.jdo.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
//import org.datanucleus.store.appengine.jdo.DatastoreJDOPersistenceManagerFactory;

/**
 * taking jdo for a walk
 * https://developers.google.com/appengine/docs/java/datastore/jdo/queries
 * https:
 * //developers.google.com/appengine/docs/java/datastore/jdo/relationships?csw=1
 * http://stackoverflow.com/questions/5379520/jdo-gae-one-to-many-problem
 * https://developers.google.com/appengine/docs/java/tools/localunittesting
 * https
 * ://developers.google.com/appengine/docs/java/datastore/jdo/overview-dn2?hl=en
 * https://developers.google.com/appengine/docs/java/datastore/jdo/queries
 * 
 * 
 */

public class LoaderTest {
	
	private static ClassPathXmlApplicationContext   context = new 
			ClassPathXmlApplicationContext("com/dhenton9000/spring/mvc/jdo/dao/impl/test-spring.xml");

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	private static PersistenceManagerFactory pmf;
	private PersistenceManager pm;

	@BeforeClass
	public static void beforeClass() {
		pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");

	}

	@Before
	public void setUp() {
		helper.setUp();

	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	 
 
	@Test
	public void testLoad() {
		
		RestaurantService service = (RestaurantService) context.getBean("restaurantService");
		service.loadSampleData();

	}
}
