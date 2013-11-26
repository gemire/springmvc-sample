package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.Review;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantDao restaurantDao;
	private static Logger log = LogManager
			.getLogger(RestaurantServiceImpl.class);
	private ReviewGenerator reviewer = new ReviewGenerator();

	@Override
	public List<Restaurant> getAllRestaurants() {

		return getRestaurantDao().getAllRestaurants();
	}

	@Override
	public Restaurant getRestaurant(Long id) {

		Key k = KeyFactory.createKey(RestaurantDao.RESTAURANT_ENTITY_NAME, id);
		return getRestaurantDao().getRestaurant(k);
	}

	@Override
	public Key saveOrAddRestaurant(Restaurant t) {

		log.debug("save or add restaurant "+t.getIdAsLong());
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Restaurant>> violations = validator.validate(t);
		if (violations.size() == 0) {
			return getRestaurantDao().saveOrAddRestaurant(t);
		} else {
			HashMap<String, String> errors = new HashMap<String, String>();
			Iterator<ConstraintViolation<Restaurant>> iter = violations
					.iterator();
			while (iter.hasNext()) {
				ConstraintViolation<Restaurant> violation = iter.next();
				errors.put(violation.getPropertyPath().toString(),
						violation.getMessage());
			}
			throw new ValidatorFailureException("errors found", errors);
		}

	}

	public RestaurantDao getRestaurantDao() {
		return restaurantDao;
	}

	public void setRestaurantDao(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}

	@Override
	public void deleteRestaurant(Long key) {
		log.debug("hit deleteRestaurant "+key);
		getRestaurantDao().deleteRestaurant(key);

	}

	/**
	 * Subway, Plymouth, WI, 53073, 1 name, city, state, zipCode, version
	 */
	@Override
	public void loadSampleData() {

		List<Restaurant> listing = this.getAllRestaurants();
		for (Restaurant r : listing) {
			this.deleteRestaurant(r.getId().getId());

		}

		InputStream dataStream = this.getClass().getClassLoader()
				.getResourceAsStream("data/restaurant.csv");

		BufferedReader br = null;
		String line = null;

		try {

			br = new BufferedReader(new InputStreamReader(dataStream));

			while ((line = br.readLine()) != null) {
				Restaurant r = new Restaurant();
				StringTokenizer t = new StringTokenizer(line, ",");
				while (t.hasMoreElements()) {
					r.setName((String) t.nextElement());
					r.setCity((String) t.nextElement());
					r.setState((String) t.nextElement());
					r.setZipCode((String) t.nextElement());
					String v = (String) t.nextElement();
					if (v != null)
						v = v.trim();
					int ver = -99;
					try {
						ver = Integer.parseInt(v);
					} catch (NumberFormatException e) {
						log.error("cannot parse " + v);
					}
					r.setVersion(ver);
					reviewer.generateReviews(r);
					log.debug("@@@ " + r.getReviews());
					saveOrAddRestaurant(r);
				}

			}

		} catch (IOException e) {
			log.error("IO problem reading sample data " + e.getMessage());
		} finally {
			if (br != null) {

				try {
					br.close();
				} catch (IOException e) {

				}

			}
		}

	}

	@Override
	public List<Restaurant> getRestaurantsWithMaxRating(int ratingLimit) {

		return getRestaurantDao().getRestaurantsWithMaxRating(ratingLimit);
	}

	@Override
	public List<Restaurant> getRestaurantsLike(String searchString) {

		return getRestaurantDao().getRestaurantsLike(searchString);
	}

	@Override
	public void deleteReview(Long restaurantId, Long reviewId) {
		Restaurant parent = getRestaurant(restaurantId);
		log.debug("hit deleteReview "+restaurantId+" "+reviewId);
		
		if (parent == null) {
			log.warn("could not find restaurant in delete review "
					+ restaurantId);
			return;
		}
		List<Review> reviews = parent.getReviews();
		log.debug("before delete "+reviews.size());
		Key restaurantKey = KeyFactory.createKey("Restaurant", restaurantId);
		Key reviewKey = KeyFactory.createKey(restaurantKey, "Review", reviewId);
		int idx = -1;
		for (int i = 0; i < reviews.size(); i++) {
			log.debug("key review " + reviewKey + " -- " + reviews.get(i).getId());
			if (reviews.get(i).getId().compareTo(reviewKey) == 0) {
				idx = i;
				break;
			}
		}
		log.debug("idx is "+idx);
		if (idx > -1) {
			log.debug("did remove ");
			parent.getReviews().remove(idx);
		}
		log.debug("after delete "+reviews.size());
		this.saveOrAddRestaurant(parent);

	}

	@Override
	public Review saveReview(Long restaurantId, Review newReview) {
		Restaurant parent = getRestaurant(restaurantId);
		log.debug("hit saveReview "+restaurantId+" "+newReview.getId().getId());
		 
		
		
		if (parent == null) {
			log.warn("could not find restaurant in saveReview " + restaurantId);
			return null;
		}
		log.debug("saveReview found parent " + parent.getIdAsLong());

		List<Review> reviews = parent.getReviews();
		Key reviewKey = newReview.getId();
		boolean isAdding = false;
		Long reviewKeyLong = null;
		if (reviewKey == null) {
			log.warn("review key null in  saveReview " + restaurantId);
			return null;
		} else {
			reviewKeyLong = new Long(reviewKey.getId());
		}
		log.debug("review Key to match: " + reviewKey);

		for (int i = 0; i < reviews.size(); i++) {
			log.debug("key review " + reviewKeyLong + " " + reviews.get(i));
			if (new Long(reviews.get(i).getId().getId())
					.compareTo(reviewKeyLong) == 0) {
				log.debug("found match ");
				Review oR = reviews.get(i);
				oR.setReviewListing(newReview.getReviewListing());
				oR.setStarRating(newReview.getStarRating());
			}
		}
		this.saveOrAddRestaurant(parent);
		return newReview;
	}

	@Override
	public Review addReview(Long restaurantId, Review newReview) {
		log.debug("hit addReview "+restaurantId);
		Restaurant parent = getRestaurant(restaurantId);
		if (parent == null) {
			log.warn("could not find restaurant in addReview " + restaurantId);
			return null;
		}

		parent.getReviews().add(newReview);
		this.saveOrAddRestaurant(parent);
		return newReview;

	}

}
