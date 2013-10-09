package com.dhenton9000.spring.rest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.dhenton9000.spring.mvc.jdo.service.impl.ValidatorFailureException;
import com.dhenton9000.spring.rest.IRestRestaurantService;
import com.google.appengine.api.datastore.Key;

@Controller
@RequestMapping(value = "rest/restaurant/*")
public class RestaurantRestController implements IRestRestaurantService {

	private static Logger log = LogManager
			.getLogger(RestaurantRestController.class);
	private RestaurantService restaurantService;

	// http://localhost:8888/app/rest/restaurant/get/4723501952925696

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.rest.controllers.IRestRestaurantService#addRestaurant(com.dhenton9000.spring.mvc.jdo.entities.Restaurant)
	 */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	RestResult addRestaurant(@RequestBody Restaurant restaurant) {
		RestResult res = new RestResult();
		log.debug("hit add restaurant");
		log.debug("restaurant is " + restaurant);
		Key k = null;
		try {
			k = this.getRestaurantService().saveOrAddRestaurant(restaurant);
		} catch (ValidatorFailureException e) {
			HashMap<String, String> errors = e.getErrors();
			res.getMessages().put("Action", "add");
			res.getMessages().put("Result", "fail");
			for (String t : errors.keySet()) {
				res.getMessages().put(t, errors.get(t));
			}
			return res;
		}

		res.getMessages().put("Action", "add");
		res.getMessages().put("Result", "success");
		res.getMessages().put("Key", new Long(k.getId()).toString());
		return res;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.rest.controllers.IRestRestaurantService#saveRestaurant(com.dhenton9000.spring.mvc.jdo.entities.Restaurant)
	 */
	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	RestResult saveRestaurant(@RequestBody Restaurant restaurant) {
		RestResult res = new RestResult();
		log.debug("hit save restaurant");
		log.debug("restaurant is " + restaurant);
		Restaurant r = this.getRestaurantService().getRestaurant(
				restaurant.getIdAsLong());
		if (r == null) {
			res.getMessages().put("Action", "edit");
			res.getMessages().put("Result", "fail");
			res.getMessages().put(
					"Message",
					"cannot find restaurant with id of '"
							+ restaurant.getIdAsLong() + "'");
			return res;

		}
		r.setCity(restaurant.getCity());
		r.setState(restaurant.getState());
		r.setVersion(restaurant.getVersion());
		r.setZipCode(restaurant.getZipCode());
		r.setName(restaurant.getName());
		Key k = null;
		try {
			k = this.getRestaurantService().saveOrAddRestaurant(restaurant);
		} catch (ValidatorFailureException e) {
			res.getMessages().put("Action", "edit");
			res.getMessages().put("Result", "fail");
			HashMap<String, String> errors = e.getErrors();
			for (String t : errors.keySet()) {
				res.getMessages().put(t, errors.get(t));
			}
			return res;
		}

		res.getMessages().put("Action", "save");
		res.getMessages().put("Result", "success");
		res.getMessages().put("Key", new Long(k.getId()).toString());

		return res;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.rest.controllers.IRestRestaurantService#getRestaurant(java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/get/{restaurantId}", method = RequestMethod.GET)
	public @ResponseBody
	Restaurant getRestaurant(@PathVariable("restaurantId") String restaurantId) {
		log.debug("hit getRestaurant!!!!");
		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Could not parse " + restaurantId);
		}
		Restaurant restaurant = this.getRestaurantService().getRestaurant(key);
		if (restaurant == null)
			restaurant = new Restaurant();
		return restaurant;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.rest.controllers.IRestRestaurantService#deleteRestaurant(java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/delete/{restaurantId}", method = RequestMethod.DELETE)
	public @ResponseBody
	RestResult deleteRestaurant(
			@PathVariable("restaurantId") String restaurantId) {
		log.debug("hit delete Restaurant!!!!");
		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Could not parse " + restaurantId
					+ " in delete");
		}

		this.getRestaurantService().deleteRestaurant(key);
		RestResult res = new RestResult();
		res.getMessages().put("Delete Result", "success");
		res.getMessages().put("Key", restaurantId);
		return res;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.rest.controllers.IRestRestaurantService#getAllRestaurants()
	 */
	@Override
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public @ResponseBody
	List<Restaurant> getAllRestaurants() {
		log.debug("hit allRestaurant!!!!");
		List<Restaurant> restaurants = this.getRestaurantService()
				.getAllRestaurants();
		if (restaurants == null)
			restaurants = new ArrayList<Restaurant>();
		return restaurants;
	}

	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

}
