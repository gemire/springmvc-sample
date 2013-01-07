/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.restaurant.maintenance;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.pages.modal.ModalInputPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public final class RestaurantFormPanel extends Panel {

    private IRestaurantDao service;

    /**
     * the model is a compound property model around a property model
     *
     * @param id
     * @param model
     * @param service
     */
    public RestaurantFormPanel(String id, IModel model, IRestaurantDao service) {
        super(id, model);
        Form<Restaurant> form = new Form<Restaurant>("restaurantForm", model) {
            @Override
            protected void onSubmit() {
                // noop the standard submit process
            }
        };
        TextField zipCodeField = new TextField("zipCode");
        form.add(zipCodeField);
        TextField versionField = new TextField("version");
        form.add(versionField);
        TextField cityField = new TextField("city");
        form.add(cityField);
        TextField nameField = new TextField("name");
        form.add(nameField);
        TextField stateField = new TextField("state");
        form.add(stateField);
        Label idLabel = new Label("id");
        form.add(idLabel);
        form.add(new Button("submitButton"));
        add(form);
    }

    /**
     * @return the service
     */
    public IRestaurantDao getService() {
        return service;
    }
}
