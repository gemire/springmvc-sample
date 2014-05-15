/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client.extractors;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.client.results.RestaurantResultObject;

/**
 *
 * @author dhenton
 */
public class GenericRestaurantExtractor extends GenericExtractor<Restaurant,RestaurantResultObject>{

    public GenericRestaurantExtractor(Class<Restaurant> deserializedModelClass, 
            Class<RestaurantResultObject> deserializedResultClass) {
        super(deserializedModelClass, deserializedResultClass);
    }
    
}
