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
import com.google.appengine.api.datastore.Key;



@Controller
@RequestMapping(value = "rest/restaurant/*")
public class RestaurantRestController {

	private static Logger log = LogManager.getLogger(RestaurantRestController.class);
	private RestaurantService restaurantService;
	// http://localhost:8888/app/rest/restaurant/get/4723501952925696
	 
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public @ResponseBody RestResult addRestaurant(@RequestBody Restaurant restaurant) {
		RestResult res = new RestResult();
		log.debug("hit add restaurant");
		log.debug("restaurant is "+restaurant);
		Key k = null;
		try {
			k = this.getRestaurantService().saveOrAddRestaurant(restaurant);
		} catch (ValidatorFailureException e) {
			 HashMap<String, String> errors = e.getErrors();
			 for (String t: errors.keySet())
			 {
				 res.getMessages().put(t, errors.get(t));
			 }
			 return res;
		}
		
		res.getMessages().put("Save/Add Result", "success");
		res.getMessages().put("Key", new Long(k.getId()).toString());
		return res ;
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public @ResponseBody RestResult saveRestaurant(@RequestBody Restaurant restaurant) {
		RestResult res = new RestResult();
		log.debug("hit edit restaurant");
		log.debug("restaurant is "+restaurant);
		Restaurant r = this.getRestaurantService().getRestaurant(restaurant.getIdAsLong());
		r.setCity(restaurant.getCity());
		r.setState(restaurant.getState());
		r.setVersion(restaurant.getVersion());
		r.setZipCode(restaurant.getZipCode());
		r.setName(restaurant.getName());
		Key k = null;
		try {
			k = this.getRestaurantService().saveOrAddRestaurant(restaurant);
		} catch (ValidatorFailureException e) {
			 HashMap<String, String> errors = e.getErrors();
			 for (String t: errors.keySet())
			 {
				 res.getMessages().put(t, errors.get(t));
			 }
			 return res;
		}
		
		
		
		return res;
	}
	
	
	
	@RequestMapping(value="/get/{restaurantId}", method = RequestMethod.GET)
	public @ResponseBody Restaurant getRestaurant(@PathVariable("restaurantId") String restaurantId)
	{
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

	@RequestMapping(value="/delete/{restaurantId}", method = RequestMethod.DELETE)
	public @ResponseBody RestResult deleteRestaurant(@PathVariable("restaurantId") String restaurantId)
	{
		log.debug("hit delete Restaurant!!!!");
		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Could not parse " + restaurantId + " in delete");
		}
		
		this.getRestaurantService().deleteRestaurant(key);
		RestResult res = new RestResult();
		res.getMessages().put("Delete Result", "success");
		res.getMessages().put("Key", restaurantId);
		return res ;
	}
	
	
	
	@RequestMapping(value="/get/all", method = RequestMethod.GET)
	public @ResponseBody List<Restaurant> getAllRestaurants()
	{
		log.debug("hit allRestaurant!!!!");
		List<Restaurant> restaurants = this.getRestaurantService().getAllRestaurants();
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
