package com.dhenton9000.spring.mvc.jdo.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.dao.impl.RestaurantDaoImpl;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.Review;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class RestaurantServiceImplTest {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	private RestaurantServiceImpl service = null;
	private RestaurantDao dao = null;

    private final  Logger logger = LoggerFactory.getLogger(RestaurantServiceImplTest.class);
	

	@Before
	public void setUp() {
		helper.setUp();
		service = new RestaurantServiceImpl();
		dao = new RestaurantDaoImpl();
		service.setRestaurantDao(dao);

	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public final void testLoadSampleData() {
		service.loadSampleData();
		List<Restaurant> restaurants = service.getAllRestaurants();
		assertEquals(50,restaurants.size());
		
		 
		for (Restaurant rv: restaurants)
		{
			if (rv.getReviews() != null)
				logger.debug(rv.getReviews().size()+" count");
			else
				logger.debug("hit null");
		}
	}

}
