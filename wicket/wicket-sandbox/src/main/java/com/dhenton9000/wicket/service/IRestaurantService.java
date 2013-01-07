/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.service;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.service.impl.RestaurantServiceImpl;
import com.google.inject.ImplementedBy;
import java.util.List;

/**
 *
 * @author dhenton
 */
@ImplementedBy(RestaurantServiceImpl.class)
public interface IRestaurantService {
    
    public List<Restaurant> getAllRestaurants();
    public void merge(Restaurant r);
    public void delete(Restaurant r);

    public Restaurant findById(Integer integer);

    
}
