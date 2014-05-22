package com.dhenton9000.spring.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dhenton9000.spring.mvc.controllers.ResourceNotFoundException;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.RestaurantDTO;
import com.dhenton9000.spring.mvc.jdo.entities.Review;
import com.dhenton9000.spring.mvc.jdo.entities.ReviewDTO;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;
import com.dhenton9000.spring.rest.NumberParsingException;
import com.google.appengine.api.datastore.Key;

@Controller
@RequestMapping(value = "backbone/restaurant")
public class BackboneRestaurantRestController {

	private static Logger log = LogManager
			.getLogger(BackboneRestaurantRestController.class);
	private RestaurantService restaurantService;

	// http://localhost:8888/app/backbone/restaurant/4723501952925696

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	BackBoneIdResponse create(@RequestBody RestaurantDTO rDTO) {
		log.debug("starting create "+rDTO);
		Key k = getRestaurantService().saveOrAddRestaurant(
				rDTO.makeRestaurant());
		log.debug("hit created id "+k.getId());
		BackBoneIdResponse res = new BackBoneIdResponse();
		res.setId(new Long(k.getId()));
		return res;
	}

	/**
	 * this will throw a ValidatorFailureException if there are problems
	 * this will be handled by com.dhenton9000.spring.rest.controllers.ControllerAdvisor
	 * @param rDTO
	 * @param id
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody RestaurantDTO rDTO,
			@PathVariable("id") String id) {
		log.debug("hit update id "+rDTO.getId());
		getRestaurantService().saveOrAddRestaurant(rDTO.makeRestaurant());
	}

	@RequestMapping(value = "{restaurantId}", method = RequestMethod.GET)
	public @ResponseBody
	RestaurantDTO getRestaurant(
			@PathVariable("restaurantId") String restaurantId) {
		log.debug("hit getRestaurant!!!!");
		Long key = null;

		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + restaurantId);
		}
		Restaurant restaurant = this.getRestaurantService().getRestaurant(key);
		if (restaurant == null)
			throw new ResourceNotFoundException("could not find key '" + key
					+ "'");
		else
			return new RestaurantDTO(restaurant);
	}

	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponseClass handleResourceNotFoundException(ResourceNotFoundException b) {
		ErrorResponseClass response = new ErrorResponseClass(b);
		return response;

	}
	
	

	@RequestMapping(value = "{restaurantId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable("restaurantId") String restaurantId) {
		Long key = null;
		log.debug("hit delete id "+restaurantId);
		try {
			key = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + restaurantId
					+ " in delete");
		}

		try {
			getRestaurantService().deleteRestaurant(key);
		} catch (JDOObjectNotFoundException e) {
			throw new ResourceNotFoundException("cannot find restaurant with key "+key);
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<RestaurantDTO> getAllRestaurants() {
		log.debug("hit allRestaurant!!!!");
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();

		List<Restaurant> rItems = this.getRestaurantService()
				.getAllRestaurants();
		for (Restaurant r : rItems) {
			restaurants.add(new RestaurantDTO(r));
		}
		return restaurants;
	}

	// /////// REVIEWS/////////////////////////////////

	@RequestMapping(value = "/review/{restaurantId}/{reviewId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void removeReview(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("reviewId") String reviewId) {
		Long restaurantIdLong = null;
		Long reviewIdLong = null;
		log.debug("hit removeReview "+restaurantId+" "+reviewId);
		try {
			restaurantIdLong = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + restaurantId
					+ " in delete");
		}

		try {
			reviewIdLong = Long.parseLong(reviewId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + reviewId
					+ " in delete");
		}

		try {
			getRestaurantService().deleteReview(restaurantIdLong, reviewIdLong);
		} catch (JDOObjectNotFoundException e) {
			String info = String.format("Cannot find review %d for restaurant %d",reviewIdLong,restaurantIdLong);
			throw new ResourceNotFoundException(info);
		}

	}

	@RequestMapping(value = "/review/{restaurantId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	BackBoneIdResponse addReview(@RequestBody ReviewDTO rDTO,
			@PathVariable("restaurantId") String restaurantId) {

		Long restaurantIdLong = null;
		log.debug("hit addReview "+restaurantId+" "+rDTO.getId());
		try {
			restaurantIdLong = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + restaurantId
					+ " in createReview");
		}
		Review ret = getRestaurantService().addReview(restaurantIdLong,
				rDTO.makeReview());
		BackBoneIdResponse res = new BackBoneIdResponse();
		res.setId(ret.getId().getId());
		return res;
	}

	@RequestMapping(value = "/review/{restaurantId}/{reviewId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void saveReview(@RequestBody ReviewDTO rDTO,
			@PathVariable("restaurantId") String restaurantId,
			@PathVariable("reviewId") String reviewId) {
		Long restaurantIdLong = null;
		log.debug("hit updateReview "+restaurantId+" "+rDTO.getId());
		
		try {
			restaurantIdLong = Long.parseLong(restaurantId);
		} catch (NumberFormatException e) {
			throw new NumberParsingException("Could not parse " + restaurantId
					+ " in updateReview");
		}

		getRestaurantService().saveReview(restaurantIdLong,
				rDTO.makeReview());
	}

	// ////////////////////////////////////////////////////////////////////////////////////

	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

}
