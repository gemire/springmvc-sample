package com.dhenton9000.spring.mvc.controllers.database;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;


@Controller
@RequestMapping(value = "/database/restaurant/load")
public class RestaurantLoaderController {
	
	private RestaurantService restaurantService;
	
	private static Logger log = LogManager
			.getLogger(RestaurantLoaderController.class);
	
	public static final String RESTAURANT_LOAD_TILES = "tiles.database.load.restaurant";
	public static final String MESSAGE_KEY = "message";
	
	@RequestMapping(value = "main")
	public ModelAndView goToLoadRestaurants() {

		ModelAndView mav = new ModelAndView(RESTAURANT_LOAD_TILES);
		mav.addObject(MESSAGE_KEY,"");
		return mav;

	}
	
	@RequestMapping(value = "load")
	public ModelAndView loadRestaurants() {

		ModelAndView mav = new ModelAndView(RESTAURANT_LOAD_TILES);
		
		restaurantService.loadSampleData();
		
		mav.addObject(MESSAGE_KEY,"Load Performed");
		return mav;

	}
	
	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

}
