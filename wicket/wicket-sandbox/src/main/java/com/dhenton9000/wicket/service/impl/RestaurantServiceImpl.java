/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.service.impl;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.service.IRestaurantService;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import java.util.List;
//http://stackoverflow.com/questions/7900592/how-do-i-use-guice-persist-guice-3-0-with-wicket-1-5
/**
 *
 * @author dhenton
 */
public class RestaurantServiceImpl implements IRestaurantService {

    @Inject
    
    private final IRestaurantDao dao;

    @Inject
    public RestaurantServiceImpl(IRestaurantDao dao) {
        this.dao = dao;
    }

    @Override
    
    public List<Restaurant> getAllRestaurants() {
        return dao.getAllRestaurants();
    }

    @Override
    
    public void merge(Restaurant r) {
        dao.merge(r);
    }

    @Override
    
    public void delete(Restaurant r) {
     
        
            dao.delete(r);
       
    }

    @Override
    
    public Restaurant findById(Integer integer) {
        return dao.findById(integer);
    }
}
