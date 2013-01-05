/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.entities.Restaurant;

/**
 *
 * @author dhenton
 */
public class RestaurantReloadableEntityModel extends ReloadableEntityModel<Restaurant,Integer>{

    public RestaurantReloadableEntityModel(Restaurant entity) {
        super(entity);
    }
    
}
