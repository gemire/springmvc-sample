/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest;

import java.util.List;
import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.controllers.RestResult;

/**
 *
 * @author dhenton
 */
public interface IRestRestaurantService {
    public abstract RestResult addRestaurant(Restaurant restaurant);

	public abstract RestResult saveRestaurant(Restaurant restaurant);

	public abstract Restaurant getRestaurant(String restaurantId);

	public abstract RestResult deleteRestaurant(String restaurantId);

	public abstract List<Restaurant> getAllRestaurants();
	public abstract List<Restaurant> getRestaurantsWithMaxRating(int r);
	public abstract List<Restaurant> getRestaurantsLike(String searchString);
}
