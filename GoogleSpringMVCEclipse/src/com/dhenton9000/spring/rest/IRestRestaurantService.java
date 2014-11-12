package com.dhenton9000.spring.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.controllers.RestResult;

public interface IRestRestaurantService {

	public abstract RestResult addRestaurant(Restaurant restaurant);

	public abstract RestResult saveRestaurant(Restaurant restaurant);

	public abstract Restaurant getRestaurant(String restaurantId);

	public abstract RestResult deleteRestaurant(String restaurantId);

	public abstract List<Restaurant> getAllRestaurants();
	public abstract List<Restaurant> getRestaurantsWithMaxRating(int r);
	public abstract List<Restaurant> getRestaurantsLike(String searchString);


}