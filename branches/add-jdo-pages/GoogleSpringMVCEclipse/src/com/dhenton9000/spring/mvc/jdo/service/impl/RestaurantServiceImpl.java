package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantServiceImpl implements RestaurantService {

	 
	private RestaurantDao restaurantDao;
	
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
		
		return getRestaurantDao().saveOrAddRestaurant(t);
		
	}

	public RestaurantDao getRestaurantDao() {
		return restaurantDao;
	}

	public void setRestaurantDao(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}

	@Override
	public void deleteRestaurant(Long key) {
		getRestaurantDao().deleteRestaurant(key);
		
	}

	 
}
