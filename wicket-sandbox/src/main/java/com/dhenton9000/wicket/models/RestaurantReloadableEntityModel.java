/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.jpa.service.support.GenericEntityService;

/**
 *
 * @author dhenton
 */
public class RestaurantReloadableEntityModel extends HibernateReloadableEntityModel<Restaurant,Integer>{

    
    
     public RestaurantReloadableEntityModel(Restaurant entity,GenericEntityService service)
     {
         super(entity);
         this.setService(service);
     }

    
}
