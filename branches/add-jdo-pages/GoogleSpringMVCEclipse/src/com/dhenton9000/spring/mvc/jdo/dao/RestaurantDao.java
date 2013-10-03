package com.dhenton9000.spring.mvc.jdo.dao;

import java.util.List;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;

public interface RestaurantDao {
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(Key id);
	public static final String RESTAURANT_ENTITY_NAME = "Restaurant";
	Key saveOrAddRestaurant(Restaurant t);
	void deleteRestaurant(Long key);
	
	
}
