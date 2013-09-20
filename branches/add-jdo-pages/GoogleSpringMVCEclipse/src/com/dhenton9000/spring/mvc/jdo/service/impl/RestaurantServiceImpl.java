package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return restaurantDao.getAllRestaurants();
	}

	@Override
	public Restaurant getRestaurant(Integer id) {
		
		Key k = KeyFactory.createKey(RestaurantDao.RESTAURANT_ENTITY_NAME, id);
		return restaurantDao.getRestaurant(k);
	}

	@Override
	public Key writeRestaurant(Restaurant t) {
		
		return restaurantDao.writeRestaurant(t);
		
	}

}
