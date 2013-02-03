/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant.two;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;

/**
 * A class that represents an event from the various Panel components
 * It will return a Restaurant or Model depending on its source. The 
 * target (MaintainRestaurantsTwo) will know what to look for.
 * 
 * @author dhenton
 */
public class RestaurantEvent {

    /**
     * @return the restaurant
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * @param restaurant the restaurant to set
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public enum REQUEST {

        ADD_REQUEST, EDIT_REQUEST, DELETE_REQUEST, CANCEL_REQUEST, SAVE_REQUEST
    };
    private RestaurantReloadableEntityModel restaurantModel = null;
    private REQUEST request = null;
    private Restaurant restaurant = null;

    public RestaurantEvent(REQUEST requestType, RestaurantReloadableEntityModel model) {
        this.restaurantModel = model;
        this.request = requestType;
    }
    public RestaurantEvent(REQUEST requestType, Restaurant restaurant) {
        this.restaurant  = restaurant;
        this.request = requestType;
    }   
    
    public RestaurantEvent() {
    }

    /**
     * @return the restaurantModel
     */
    public RestaurantReloadableEntityModel getRestaurantModel() {
        return restaurantModel;
    }

    /**
     * @param restaurantModel the restaurantModel to set
     */
    public void setRestaurantModel(RestaurantReloadableEntityModel restaurantModel) {
        this.restaurantModel = restaurantModel;
    }

    /**
     * @return the request
     */
    public REQUEST getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(REQUEST request) {
        this.request = request;
    }
}
