/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.impl.RestaurantDaoImpl;
import java.util.List;
 

/**
 *
 * @author dhenton
 */

public interface IRestaurantDao extends GenericDao<Restaurant, Integer>{

   List<Restaurant> getAllRestaurants();
    
    
}
