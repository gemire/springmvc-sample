/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.wicket.pages.form.listview;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Don
 */
public class ListDO implements Serializable {
    private IRestaurantService service;
    private List<SelectedRestaurant> selectedRestaurants 
            = new ArrayList<SelectedRestaurant>();
    private IModel<List<SelectedRestaurant>> availableRestaurantsModel;
    private final Logger logger = LoggerFactory.getLogger(ListDO.class);
    
    public ListDO(final IRestaurantService service)
    {
        this.service = service;
        availableRestaurantsModel = new LoadableDetachableModel<List<SelectedRestaurant>>()
        {

            @Override
            protected void onAttach() {
                super.onAttach(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void detach() {
                 
                super.detach(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void onDetach() {
                 logger.debug("in on detach");
            }

              @Override
            protected List<SelectedRestaurant> load() {
                
                
                List<Restaurant> allRestaurants = ListDO.this.service.getAllRestaurants();
                logger.debug("load - starting with "+allRestaurants.size());
                ArrayList<SelectedRestaurant> newAvailableRestaurants = new ArrayList<SelectedRestaurant>();
               
                for (Restaurant r: allRestaurants)
                {
                    newAvailableRestaurants.add(new SelectedRestaurant(r));
                }
                 
                boolean didRemove = newAvailableRestaurants.removeAll(selectedRestaurants);
                logger.debug("did remove "+didRemove+" "+newAvailableRestaurants.size());
                return newAvailableRestaurants;
            }
            
        };
        
    }

   

    /**
     * @return the selectedRestaurants
     */
    public List<SelectedRestaurant> getSelectedRestaurants() {
        return selectedRestaurants;
    }

    /**
     * @param selectedRestaurants the selectedRestaurants to set
     */
    public void setSelectedRestaurants(List<SelectedRestaurant> selectedRestaurants) {
        this.selectedRestaurants = selectedRestaurants;
    }

    /**
     * @return the availableRestaurants
     */
    public IModel<List<SelectedRestaurant>> getAvailableRestaurantsModel() {
        return availableRestaurantsModel;
    }

    /**
     * @param availableRestaurants the availableRestaurants to set
     */
    public void setAvailableRestaurants(IModel<List<SelectedRestaurant>> a) {
        this.availableRestaurantsModel = a;
    }
    
    

  
   
}
