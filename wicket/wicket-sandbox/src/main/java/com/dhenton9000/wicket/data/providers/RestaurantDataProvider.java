/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.data.providers;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class RestaurantDataProvider implements IDataProvider {

    private Logger logger = LoggerFactory.getLogger(RestaurantDataProvider.class);
    private final IModel<String> filter;
    private IRestaurantService service;

    public RestaurantDataProvider(IRestaurantService service,IModel<String> filter) {
        this.service = service;
        this.filter = filter;
    }

    public RestaurantDataProvider(IRestaurantService service) {
        this.service = service;
        this.filter = null;
    }

    @Override
    public Iterator iterator(long first, long count) {
        List<Restaurant> r = null;
        if (filter == null) {
            r = getService().getAllRestaurants();
        } else {
            if (filter.getObject() != null)
                r = getService().getAllRestaurants(filter.getObject());
            else
                r = getService().getAllRestaurants();
                
        }

        return r.subList((int) first, (int) (first + count)).iterator();
        //return r.iterator();

    }

    @Override
    public long size() {
        List<Restaurant> r = null;
        if (filter == null) {
            r = getService().getAllRestaurants();
        } else {
            if (filter.getObject() != null)
                r = getService().getAllRestaurants(filter.getObject());
            else
                r = getService().getAllRestaurants();
        }

        // logger.debug("size "+r.size());
        return (long) r.size();
    }

    @Override
    public IModel<Restaurant> model(Object t) {
        return new RestaurantReloadableEntityModel((Restaurant) t, getService());
    }

    @Override
    public void detach() {
    }

    /**
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }
}
