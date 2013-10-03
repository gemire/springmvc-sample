package com.dhenton9000.spring.mvc.controllers.database;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;

@Controller
@RequestMapping(value = "/database/simple/restaurant/")
@SessionAttributes({ "restaurantBean", "state" })
public class BasicDatabaseController {

	private RestaurantService restaurantService;
	private static Logger log = LogManager
			.getLogger(BasicDatabaseController.class);
	public static final String RESTAURANT_LIST_TILES = "tiles.database.list.restaurant";
	public static final String RESTAURANT_ADD_TILES = "tiles.database.add.restaurant";
	public static final String RESTAURANT_EDIT_TILES = "tiles.database.edit.restaurant";
	public static final String RESTAURANT_BEAN_KEY = "restaurantBean";
	public static final String STATE_KEY = "state";

	@RequestMapping(value = "main")
	public ModelAndView goToSimpleRestaurants(HttpSession session) {

		ModelAndView mav = loadRestaurantList(null);
		mav.addObject(RESTAURANT_BEAN_KEY, new Restaurant());
		session.removeAttribute(STATE_KEY);

		return mav;

	}

	@RequestMapping(value = "add")
	public ModelAndView addRestaurant() {

		Restaurant restaurant = new Restaurant();
		ModelAndView mav = new ModelAndView(RESTAURANT_ADD_TILES,
				RESTAURANT_BEAN_KEY, restaurant);
		mav.addObject("stateMessage", "Add Restaurant");
		mav.addObject(STATE_KEY, "ADD");
		return mav;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteRestaurant(
			@RequestParam("restaurantId") String restaurantId,HttpSession session) {

		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Could not parse " + restaurantId);
		}

		this.getRestaurantService().deleteRestaurant(key);


		ModelAndView mav = loadRestaurantList(null);
		mav.addObject(RESTAURANT_BEAN_KEY, new Restaurant());
		session.removeAttribute(STATE_KEY);
		return mav;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView editRestaurant(
			@RequestParam("restaurantId") String restaurantId) {
		log.info("edit " + restaurantId);
		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Could not parse " + restaurantId);
		}
		Restaurant restaurant = this.getRestaurantService().getRestaurant(key);
		ModelAndView mav = new ModelAndView(RESTAURANT_EDIT_TILES,
				RESTAURANT_BEAN_KEY, restaurant);
		mav.addObject("stateMessage", "Edit Restaurant");
		mav.addObject(STATE_KEY, "EDIT");
		return mav;
	}

	private ModelAndView loadRestaurantList(String message) {
		DatabaseView d = new DatabaseView();
		d.setMessage(message);
		List<Restaurant> restaurants = getRestaurantService()
				.getAllRestaurants();
		d.setRestaurants(restaurants);
		ModelAndView mav = new ModelAndView(RESTAURANT_LIST_TILES, "viewItem",
				d);
		return mav;
	}

	@RequestMapping(value = "formProcessRestaurant", method = RequestMethod.POST)
	public ModelAndView formProcessRestaurant(
			@Valid @ModelAttribute("restaurantBean") Restaurant restaurant,
			BindingResult result, WebRequest webRequest, HttpSession session,
			Model model) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			// this is handy to get the property keys
			// in ValidationMessages.properties
			log.debug("ERRORS " + result.getAllErrors());
			String state = (String) session.getAttribute(STATE_KEY);

			if (state.equals("ADD")) {
				mav = new ModelAndView(RESTAURANT_ADD_TILES);
				mav.addObject("stateMessage", "Add Restaurant");
				return mav;
			} else {
				mav = new ModelAndView(RESTAURANT_EDIT_TILES);
				mav.addObject("stateMessage", "Edit Restaurant");
				return mav;
			}
		} else {
			log.debug("success");
			log.debug("restaurant name " + restaurant.getName());
			this.getRestaurantService().saveOrAddRestaurant(restaurant);
			mav = loadRestaurantList(null);

		}

		return mav;

	}

	public class DatabaseView {
		private String message;
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
