package com.dhenton9000.spring.mvc.jdo.dao;

import java.util.List;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;

public interface RestaurantDao {

	public static final String RESTAURANT_ENTITY_NAME = "Restaurant";

	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(Key id);
	Key saveOrAddRestaurant(Restaurant t);
	void deleteRestaurant(Long key);
	void deleteReview(Long key);
	List<Restaurant> getRestaurantsWithMaxRating(int maxRating);
	List<Restaurant> getRestaurantsLike(String searchString);
	
}

