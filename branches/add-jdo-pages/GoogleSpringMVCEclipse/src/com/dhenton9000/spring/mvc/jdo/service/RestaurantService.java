package com.dhenton9000.spring.mvc.jdo.service;

import java.util.List;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;

public interface RestaurantService {

	
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(Integer id);
	Key writeRestaurant(Restaurant t);
}