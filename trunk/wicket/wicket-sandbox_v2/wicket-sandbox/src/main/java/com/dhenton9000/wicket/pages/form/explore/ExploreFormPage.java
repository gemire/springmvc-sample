/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.explore;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author dhenton
 */
public final class ExploreFormPage extends TemplatePage {

    @SpringBean
    private IRestaurantService service;
    private ExplorePanel explorePanel = null;
    private Restaurant selectedRestaurant = new Restaurant();

    public ExploreFormPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        setDefaultModel(new PropertyModel(ExploreFormPage.this, "selectedRestaurant"));
        explorePanel = new ExplorePanel("explorePanel",
                getDefaultModel(), service);
        add(explorePanel);


    }

    /**
     * @return the selectedRestaurant
     */
    public Restaurant getSelectedRestaurant() {
        return selectedRestaurant;
    }

    /**
     * @param selectedRestaurant the selectedRestaurant to set
     */
    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
    }
}
