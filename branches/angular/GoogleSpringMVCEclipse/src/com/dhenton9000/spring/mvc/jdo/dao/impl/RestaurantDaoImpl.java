package com.dhenton9000.spring.mvc.jdo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.datanucleus.exceptions.NucleusObjectNotFoundException;

import javax.jdo.JDOObjectNotFoundException;

import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.Review;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantDaoImpl implements RestaurantDao {
	private static PersistenceManagerFactory pmf;
	private static Logger log = LogManager.getLogger(RestaurantDaoImpl.class);

	public RestaurantDaoImpl() {
		pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAllRestaurants() {
		Query q = null;
		List<Restaurant> results = new ArrayList<Restaurant>();
		List<Restaurant> detachedResults = null;
		PersistenceManager pm = null;
		log.debug("begin getAllRestaurants()");
		try {
			pm = pmf.getPersistenceManager();
			q = pm.newQuery(Restaurant.class);
			q.setOrdering("name");
			results = (List<Restaurant>) q.execute();
			log.debug("found " + results.size() + " restaurants ");
			detachedResults = new ArrayList<Restaurant>();
			for (Restaurant r : results) {
				detachedResults.add(pm.detachCopy(r));
			}
		} finally {
			q.closeAll();
			pm.close();
		}
		return detachedResults;
	}

	@Override
	public Restaurant getRestaurant(Key id) {

		if (id == null)
			return null;
		Restaurant results = null;
		Restaurant detached = null;
		PersistenceManager pm = null;
		try {
			pm = pmf.getPersistenceManager();

			results = pm.getObjectById(Restaurant.class, id);
			detached = pm.detachCopy(results);
		}

		catch (NucleusObjectNotFoundException err) {
			log.warn("could not find restaurant with id of " + id.getId());

		} catch (JDOObjectNotFoundException err) {
			log.warn("could not find restaurant with id of " + id.getId());

		}

		finally {

			pm.close();
		}

		return detached;
	}

	@Override
	public Key saveOrAddRestaurant(Restaurant restaurantItem) {
		PersistenceManager pm = null;
		Key k = restaurantItem.getId();
		String info = "in saveOrAddRestaurant ";
		if (k != null) {
			long kvar = k.getId();
			info += "found key " + kvar;
		} else {
			info += " found key null";
		}
		Restaurant r = null;
		try {
			pm = pmf.getPersistenceManager();
			r = pm.makePersistent(restaurantItem);
			Long newRestaurantKey = r.getIdAsLong();
			if (r.getReviews() != null) {
				for (Review rv : r.getReviews()) {
					rv.setParentRestaurantId(newRestaurantKey);
					//rv.setRestaurant(restaurantItem);
					pm.makePersistent(rv);
				}
			}
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
			Key id = KeyFactory.createKey("Restaurant", key);
			Restaurant t = pm.getObjectById(Restaurant.class, id);
			pm.deletePersistent(t);
		} catch (NucleusObjectNotFoundException err) {
			log.warn("could not find restaurant with id of " + key
					+ " for delete");

		} finally {
			pm.close();
		}

	}

	@Override
	public void deleteReview(Long key) {
		PersistenceManager pm = null;
		try {
			pm = pmf.getPersistenceManager();
			Key id = KeyFactory.createKey("Review", key);
			Review t = pm.getObjectById(Review.class, id);
			pm.deletePersistent(t);
		} catch (NucleusObjectNotFoundException err) {
			log.warn("could not find review with id of " + key + " for delete");

		} finally {
			pm.close();
		}

	}

	@Override
	public List<Restaurant> getRestaurantsWithMaxRating(int ratingLimit) {
		List<Restaurant> all = getAllRestaurants();
		ArrayList<Restaurant> found = new ArrayList<Restaurant>();
		for (Restaurant r : all) {
			boolean addToList = true;
			if (r.getReviews() != null) {
				for (Review rv : r.getReviews()) {
					if (rv.getStarRating() > ratingLimit) {
						addToList = false;
						break;
					}
				}
				if (addToList) {
					found.add(r);
				}
			}
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getRestaurantsLike(String searchString) {

		List<Restaurant> all = getAllRestaurants();
		ArrayList<Restaurant> found = new ArrayList<Restaurant>();
		for (Restaurant r : all) {
			if (r.getName().toUpperCase().indexOf(searchString.toUpperCase()) > -1) {
				found.add(r);
			}

		}
		return found;
	}

}
