package com.dhenton9000.spring.rest.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;




@Controller
@RequestMapping(value = "rest/restaurant/*")
public class RestaurantRestController {

	private static Logger log = LogManager.getLogger(RestaurantRestController.class);
	private RestaurantService restaurantService;
	// http://localhost:8888/app/rest/restaurant/get/4723501952925696
	 
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
	
	
	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
}
