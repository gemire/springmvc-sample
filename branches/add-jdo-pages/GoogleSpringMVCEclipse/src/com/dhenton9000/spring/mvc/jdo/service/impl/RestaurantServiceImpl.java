package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantDao restaurantDao;
	private static Logger log = LogManager
			.getLogger(RestaurantServiceImpl.class);

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

	/**
	 * Subway, Plymouth, WI, 53073, 1 
	 * name, city, state, zipCode, version
	 */
	@Override
	public void loadSampleData() {

		
		List<Restaurant> listing = this.getAllRestaurants();
		for (Restaurant r:listing)
		{
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
						log.error("cannot parse "+v);
					}
					r.setVersion(ver);
					log.debug(r);
					saveOrAddRestaurant(r) ;
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

}
