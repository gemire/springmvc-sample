package com.dhenton9000.spring.mvc.jdo.service.impl;


// transactions
// https://groups.google.com/forum/#!topic/google-appengine-java/VMg9xiQv1jM
//https://code.google.com/p/datanucleus-appengine/source/browse/#svn/trunk/tests/com/google/appengine/datanucleus/test/jdo

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

	private final Logger logger = LoggerFactory
			.getLogger(RestaurantServiceImplTest.class);

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

	@Ignore
	public final void testLoadSampleData() {
		service.loadSampleData();
		List<Restaurant> restaurants = service.getAllRestaurants();
		assertEquals(50, restaurants.size());
		Restaurant tester = null;

		for (Restaurant rv : restaurants) {
			if (rv.getReviews() != null) {
				logger.debug(rv.getReviews().size() + " count");
				if (rv.getReviews().size() > 0)
					tester = rv;
			} else
				logger.debug("hit null");
		}

		Review findReview = tester.getReviews().get(0);
		assertEquals(findReview.getParentRestaurantId(),tester.getIdAsLong());

	}
	
	@Test
	public void testStringSearch()
	{
		service.loadSampleData();
		List<Restaurant> restaurants = service.getRestaurantsLike("Subway");
		assertEquals(6,restaurants.size());
	}
	
	@Test
	public void testRatingSearch()
	{
		service.loadSampleData();
		List<Restaurant> restaurants = service.getRestaurantsWithMaxRating(6);
		assertTrue(restaurants.size()>0);
	}
	

}
