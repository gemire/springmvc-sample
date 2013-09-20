package com.dhenton9000.spring.mvc.jdo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;

public class RestaurantDaoImpl implements RestaurantDao {
	private static PersistenceManagerFactory pmf;

	public RestaurantDaoImpl() {
		pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAllRestaurants() {
		Query q = null;
		List<Restaurant> results = null;
		PersistenceManager pm = null;
		try {
			pm = pmf.getPersistenceManager();
			q = pm.newQuery(Restaurant.class);
			results = (List<Restaurant>) q.execute();
		} finally {
			q.closeAll();
			pm.close();
		}
		if (results == null) {
			results = new ArrayList<Restaurant>();
		}
		return results;
	}

	@Override
	public Restaurant getRestaurant(Key id) {

		Restaurant results = null;
		PersistenceManager pm = null;
		try {
			pm = pmf.getPersistenceManager();

			results = pm.getObjectById(Restaurant.class, id);
		} finally {

			pm.close();
		}
		return results;
	}

	public Key writeRestaurant(Restaurant t) {
		PersistenceManager pm = null;
		Restaurant r  = null;
		try {
			pm = pmf.getPersistenceManager();
			r  = pm.makePersistent(t);
		} finally {
			pm.close();
		}
		return r.getId();
	}
}
