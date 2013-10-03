package com.dhenton9000.spring.mvc.jdo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantDaoImpl implements RestaurantDao {
	private static PersistenceManagerFactory pmf;
	private static Logger log = LogManager
			.getLogger(RestaurantDaoImpl.class);
	public RestaurantDaoImpl() {
		pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAllRestaurants() {
		Query q = null;
		List<Restaurant> results = null;
		PersistenceManager pm = null;
		log.debug("begin getAllRestaurants()");
		try {
			pm = pmf.getPersistenceManager();
			q = pm.newQuery(Restaurant.class);
			results = (List<Restaurant>) q.execute();
			log.debug("found "+results.size()+" restaurants ");
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


	@Override
	public Key saveOrAddRestaurant(Restaurant t) {
		PersistenceManager pm = null;
		Key k = t.getId();
		String info = "in saveOrAddRestaurant ";
		if (k != null)
		{
			long kvar = k.getId();
			info += "found key "+kvar;
		}
		else
		{
			info += " found key null";
		}
		Restaurant r  = null;
		try {
			pm = pmf.getPersistenceManager();
			r  = pm.makePersistent(t);
			log.debug(info);
		} finally {
			pm.close();
		}
		return r.getId();
	}

	@Override
	public void deleteRestaurant(Long key) {
		PersistenceManager pm = null;
		try {
			pm = pmf.getPersistenceManager();
			Key id = KeyFactory.createKey("Restaurant",key);
			Restaurant t = pm.getObjectById(Restaurant.class, id);
			pm.deletePersistent(t);
			 
		} finally {
			pm.close();
		}
		
	}
}
