/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.restaurant.maintenance;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author dhenton
 */
public final class RestaurantFormPanel extends Panel {

    private IRestaurantDao service;
    private Form<Restaurant> mainEditForm = null;

    /**
     * the model is a compound property model around a property model
     *
     * @param id
     * @param model
     * @param service
     */
    public RestaurantFormPanel(String id, IModel model, final IRestaurantDao service) {
        super(id, model);
        mainEditForm = new Form<Restaurant>("restaurantForm", model) {
            
            @Override
            protected void onSubmit() {

                Restaurant modelObject = getModelObject();
                service.merge(modelObject);
                getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);

            }
            
             @Override
            public boolean isVisible() {
                boolean isVisible = false;

                switch (getContainingPage().getState()) {
                    case ADD:
                        isVisible = true;
                        break;
                    case EDIT:
                        isVisible = true;
                        break;
                    case INITIAL:
                        
                        break;
                    case DELETE:
                        break;
                }


                return isVisible;
            }
            
            
            
            
        };
        TextField zipCodeField = new TextField("zipCode");
        mainEditForm.add(zipCodeField);
        TextField versionField = new TextField("version");
        mainEditForm.add(versionField);
        TextField cityField = new TextField("city");
        mainEditForm.add(cityField);
        TextField nameField = new TextField("name");
        mainEditForm.add(nameField);
        TextField stateField = new TextField("state");
        mainEditForm.add(stateField);
        Label idLabel = new Label("id");
        mainEditForm.add(idLabel);
        mainEditForm.add(new Button("submitButton", new Model("Save Edits")));
        add(mainEditForm);

        Form cancelForm = new Form("cancelForm");
        Button cancelButton = new Button("cancelButton", new Model("Cancel")) {
            @Override
            public void onSubmit() {
               // mainEditForm.clearInput();
                getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);
            }

            @Override
            public boolean isVisible() {
                boolean isVisible = true;

                switch (getContainingPage().getState()) {
                    case ADD:
                        break;
                    case EDIT:
                        break;
                    case INITIAL:
                        isVisible = false;
                        break;
                    case DELETE:
                        break;
                }


                return isVisible;
            }
        };

        cancelForm.add(cancelButton);
        add(cancelForm);


    }

    
    /**
     * @return the service
     */
    public IRestaurantDao getService() {
        return service;
    }

    public MaintainRestaurants getContainingPage() {
        return (MaintainRestaurants) getParent();
    }
    
    public void resetMainForm()
    {
        mainEditForm.clearInput();
    }
}
