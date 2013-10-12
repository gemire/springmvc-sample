package com.dhenton9000.spring.mvc.jdo.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.Review;
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

public class JDOTest {
	private static final String SAMPLE_CITY_NAME = "Bodega Bay";
	private static final int SAMPLE_ID = 666;
	private static final String RESTAURANT_NAME = "Alice's";
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
	public void simpleJdoWithMyOwnKey() {

		Key k = KeyFactory.createKey("Restaurant", SAMPLE_ID);

		Restaurant t = new Restaurant(k);
		t.setName(RESTAURANT_NAME);
		t.setCity(SAMPLE_CITY_NAME);

		boolean notFound = false;
		try {
			pm = pmf.getPersistenceManager();
			pm.getObjectById(Restaurant.class, SAMPLE_ID);
			fail("should have raised not found");
		} catch (JDOObjectNotFoundException e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);

		try {
			pm = pmf.getPersistenceManager();
			pm.makePersistent(t);
		} finally {
			pm.close();
		}

		try {
			pm = pmf.getPersistenceManager();
			t = pm.getObjectById(Restaurant.class, SAMPLE_ID);
		} finally {
			pm.close();
		}

		assertNotNull(pm);
		assertEquals(RESTAURANT_NAME, t.getName());
	}

	
	@Test
	public void simpleJdoWithMyOwnKeyAndReviews() {

		Key k = KeyFactory.createKey("Restaurant", SAMPLE_ID);

		Restaurant t = new Restaurant(k);
		t.setName(RESTAURANT_NAME);
		t.setCity(SAMPLE_CITY_NAME);
		t.addReview(4, "get a job");
		t.addReview(5, "get a job 3"); 

		assertEquals(2,t.getReviews().size());
		boolean notFound = false;
		try {
			pm = pmf.getPersistenceManager();
			pm.getObjectById(Restaurant.class, SAMPLE_ID);
			fail("should have raised not found");
		} catch (JDOObjectNotFoundException e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);

		try {
			pm = pmf.getPersistenceManager();
			pm.makePersistent(t);
		} finally {
			pm.close();
		}

		try {
			pm = pmf.getPersistenceManager();
			t = pm.getObjectById(Restaurant.class, SAMPLE_ID);
			assertEquals(SAMPLE_CITY_NAME,t.getCity());
			assertEquals(2,t.getReviews().size());
			 
		} finally {
			pm.close();
		}

		assertNotNull(pm);
		assertEquals(RESTAURANT_NAME, t.getName());
	}
	
	
	
	
	
	@Test
	public void simpleJdoWithGeneratedKey() {

		Restaurant t = new Restaurant();
		t.setName(RESTAURANT_NAME);
		t.setCity(SAMPLE_CITY_NAME);

		boolean notFound = false;
		try {
			pm = pmf.getPersistenceManager();
			pm.getObjectById(Restaurant.class, 1);
			fail("should have raised not found");
		} catch (JDOObjectNotFoundException e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);

		writeRestaurant(t);

		try {
			pm = pmf.getPersistenceManager();
			t = pm.getObjectById(Restaurant.class, 1);
		} finally {
			pm.close();
		}

		assertNotNull(pm);
		assertEquals(RESTAURANT_NAME, t.getName());

	}

	@Test(expected = JDOObjectNotFoundException.class)
	public void testToSeeIfTestsBleedOver() {
		pm = pmf.getPersistenceManager();
		pm.getObjectById(Restaurant.class, SAMPLE_ID);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testQuery() {
		Restaurant t = new Restaurant();
		t.setName(RESTAURANT_NAME);
		t.setCity(SAMPLE_CITY_NAME);
		t.setVersion(3);
		t.setState("CA");
		writeRestaurant(t);
		Query q = null;
		try {
			pm = pmf.getPersistenceManager();
			q = pm.newQuery(Restaurant.class);
			q.setFilter("city == cityParam");
			// q.setOrdering("height desc");
			q.declareParameters("String cityParam");
			// q.declareParameters("String cityPararm,int itemCountParam");

			List<Restaurant> results = (List<Restaurant>) q
					.execute(SAMPLE_CITY_NAME);
			if (!results.isEmpty()) {
				assertEquals(1, results.size());
				assertEquals(SAMPLE_CITY_NAME, results.get(0).getCity());
			} else {
				fail("couldn't find anyting");
			}
		} finally {
			q.closeAll();
			pm.close();
		}

	}

	private void writeRestaurant(Restaurant t) {
		try {
			pm = pmf.getPersistenceManager();
			pm.makePersistent(t);
		} finally {
			pm.close();
		}
	}

}
