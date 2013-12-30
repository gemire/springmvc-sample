/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;


import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class RestaurantServiceImpl extends 
        GenericEntityServiceImpl<Restaurant,Integer> 
implements IRestaurantService {

    protected IRestaurantDao  restaurantDao;

    @Autowired
    public void setRestaurantDao(IRestaurantDao gDAO) {
        this.restaurantDao = gDAO;
    }

    
    @Override
    public IRestaurantDao getDao() {
        return restaurantDao;
    }

    @Override
    public Restaurant getNew() {
        return new Restaurant();
    }

    @Override
    public Restaurant getNewWithDefaults() {
        return getNew();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
       return getDao().getAllRestaurants();
    }

    @Override
    public List<Restaurant> getAllRestaurants(String filter) {
        ArrayList filtered = new ArrayList<Restaurant>();
        List<Restaurant> rList = getDao().getAllRestaurants();
        for (Restaurant r: rList)
        {
            if (r.getName().indexOf(filter) > -1)
            {
                filtered.add(r);
            }
        }
        
        return filtered;
    }
}
