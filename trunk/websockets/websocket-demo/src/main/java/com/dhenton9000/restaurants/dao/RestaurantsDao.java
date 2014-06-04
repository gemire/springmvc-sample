/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.restaurants.dao;

import com.dhenton9000.restaurants.model.Restaurant;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface RestaurantsDao {
    List<Restaurant>  getAll();
}
