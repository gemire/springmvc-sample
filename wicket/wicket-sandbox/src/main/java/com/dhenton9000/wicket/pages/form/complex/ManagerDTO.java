/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.complex;

import com.dhenton9000.jpa.entities.Manager;
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.util.ListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class ManagerDTO implements Serializable {

    private final IRestaurantService service;
    private final IModel<List<Restaurant>> availableRestaurants;
    private final IModel<List<Restaurant>> allRestaurants;
    /**
     * what they have currently selected to be moved over
     */
    private final IModel<List<Restaurant>> selectedRestaurants;
    /**
     * the accumulated set of choices
     */
    private IModel<List<CandidateRestaurant>> candidateRestaurants;
    private final Logger logger = LoggerFactory.getLogger(ManagerDTO.class);
    private Manager manager = new Manager();

    public ManagerDTO(final IRestaurantService service) {
        this.service = service;

        allRestaurants = new LoadableDetachableModel<List<Restaurant>>() {

            @Override
            protected List<Restaurant> load() {
                return ManagerDTO.this.service.getAllRestaurants();
            }

        };

        availableRestaurants = new LoadableDetachableModel<List<Restaurant>>() {

            @Override
            protected List<Restaurant> load() {

                final Comparator<Restaurant> sorter = new Comparator<Restaurant>() {

                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }

                };

                allRestaurants.detach();
                ArrayList<Restaurant> aList = new ArrayList<Restaurant>();
                for (Restaurant r : allRestaurants.getObject()) {
                    boolean foundIt = false;
                    for (CandidateRestaurant c : candidateRestaurants.getObject()) {
                        if (r.equals(c.getRestaurant())) {
                            foundIt = true;
                            break;
                        }
                    }
                    if (!foundIt) {
                        aList.add(r);
                    }
                }
                Collections.sort(aList, sorter);
                return aList;

            }

        };

        selectedRestaurants = new ListModel(new ArrayList<Restaurant>());
        candidateRestaurants = new ListModel(new ArrayList<CandidateRestaurant>());

    }

    /**
     * @return the availableRestaurants
     */
    public IModel<List<Restaurant>> getAvailableRestaurants() {
        return availableRestaurants;
    }

    /**
     * @return the allRestaurants
     */
    public IModel<List<Restaurant>> getAllRestaurants() {
        return allRestaurants;
    }

    /**
     * @return the selectedRestaurants
     */
    public IModel<List<Restaurant>> getSelectedRestaurants() {
        return selectedRestaurants;
    }

    public void setName(String t) {
        this.manager.setName(t);
    }

    public void setPhone(String p) {
        this.manager.setPhone(p);

    }

    public Manager getInternalManager() {
        return manager;
    }

    public String getName() {
        return manager.getName();
    }

    public String getPhone() {
        return manager.getPhone();
    }

    IModel<List<CandidateRestaurant>> getCandidateRestaurants() {
        return candidateRestaurants;
    }

}
