package com.dhenton9000.spring.mvc.controllers.database;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.controllers.ComplexFormController;
import com.dhenton9000.spring.mvc.jdo.dao.RestaurantDao;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.dhenton9000.spring.mvc.model.FormBean;

@Controller
@RequestMapping(value = "/database/simple/restaurant/")
@SessionAttributes("restaurantBean")
public class BasicDatabaseController {

	
	private RestaurantService restaurantService;
	private static Logger log = LogManager
			.getLogger(BasicDatabaseController.class);
	public static final String RESTAURANT_FORM_TILES = "tiles.database.simple.restaurant";
	public static final String RESTAURANT_BEAN_KEY = "restaurantBean";

	@RequestMapping(value = "main")
	public ModelAndView goToSimpleRestaurants() {
		
		
		ModelAndView mav = loadRestaurantList(null);
		mav.addObject(RESTAURANT_BEAN_KEY, new Restaurant());
		return mav ;
		
		 

	}

	private ModelAndView loadRestaurantList(String message) {
		DatabaseView d = new DatabaseView();
		d.setMessage(message);
		List<Restaurant> restaurants = getRestaurantService().getAllRestaurants();
		d.setRestaurants(restaurants);
		
		StringBuilder b = new StringBuilder();
		log.info("begining call "+restaurants.size());
		
		for (Restaurant r: restaurants)
		{
			b.append(r.getName()+"\n");
		}
		log.info("\n================\n"+b.toString());

		ModelAndView mav = new ModelAndView(RESTAURANT_FORM_TILES, "viewItem", d);
		return mav;
	}

	@RequestMapping(value = "addRestaurant", method = RequestMethod.POST)
	public ModelAndView addEditRestaurant(
			@Valid @ModelAttribute("restaurantBean") Restaurant restaurant,
			BindingResult result, WebRequest webRequest, HttpSession session,
			Model model) {

		
		if (result.hasErrors())
		{
			//this is handy to get the property keys
			//in ValidationMessages.properties
			log.debug("ERRORS "+result.getAllErrors());
		}
		else
		{
			log.debug("success");
			log.debug("restaurant name "+restaurant.getName());
			this.getRestaurantService().writeRestaurant(restaurant);	 
		}
		String message = "Successfully added restaurant '"+restaurant.getName()+"'";
	//	session.setAttribute(RESTAURANT_BEAN_KEY, new Restaurant());
		restaurant.clear();
		
		ModelAndView mav = loadRestaurantList(message);
		mav.addObject(RESTAURANT_BEAN_KEY, restaurant);
		return mav;
		 
	}
	
	public class DatabaseView 
	{
		private String message ;
		private List<Restaurant> restaurants;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<Restaurant> getRestaurants() {
			return restaurants;
		}

		public void setRestaurants(List<Restaurant> restaurants) {
			this.restaurants = restaurants;
		}
		
	}

	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	 
}
