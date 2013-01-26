/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.jpa.service.support.GenericEntityService;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface IRestaurantService extends GenericEntityService<Restaurant,Integer> {
    List<Restaurant> getAllRestaurants();
}
 