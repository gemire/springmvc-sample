/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.data;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.data.providers.RestaurantsDataView;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class RestaurantsDataViewActionPanel extends Panel {

    Logger logger = LoggerFactory.getLogger(RestaurantsDataViewActionPanel.class);

    /**
     * @param id component id
     * @param model model for contact
     */
    public RestaurantsDataViewActionPanel(String id, IModel<Restaurant> model) {
        super(id, model);
        add(new Link("select") {
            @Override
            public void onClick() {
                Restaurant selected;
                selected = (Restaurant) getParent().getDefaultModelObject();
                logger.debug("select " + selected);
            }
        }.add(new Label("restaurantName", model.getObject().getName())));
         
        
         
    }
}