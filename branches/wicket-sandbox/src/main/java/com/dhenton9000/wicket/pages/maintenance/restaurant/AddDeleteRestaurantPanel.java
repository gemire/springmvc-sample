/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IChainingModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class AddDeleteRestaurantPanel extends Panel {

    private Form addDeleteRestaurantForm;
    private RestaurantReloadableEntityModel selectedRestaurantModel = null;
    private final Logger logger = LoggerFactory.getLogger(AddDeleteRestaurantPanel.class);

    /**
     * The model  propertymodel of the containing page
     *
     * @param id
     * @param model
     * @param service
     */
    public AddDeleteRestaurantPanel(String id) {
        super(id);
       // selectedRestaurantModel = (RestaurantReloadableEntityModel) model.getChainedModel();

        addDeleteRestaurantForm = new Form("addDeleteForm") {
            @Override
            protected void onSubmit() {
            }
        };



        Button addButton = new Button("addButton", new Model("Add")) {
            @Override
            public void onSubmit() {
                
                getContainingPage().performStateOperation(MaintainRestaurants.STATE.ADD);
               // setSelectedRestaurant(new Restaurant());
            }

            @Override
            public boolean isVisible() {
                boolean isVisible = false;

                switch (getContainingPage().getState()) {
                    case ADD:
                        break;
                    case EDIT:
                        break;
                    case INITIAL:
                        isVisible = true;
                        break;
                    case DELETE:
                        break;
                }


                return isVisible;
            }
        };


        Button deleteButton = new Button("deleteButton", new Model("Delete")) {
            @Override
            public void onSubmit() {
               // Restaurant r = (Restaurant) getPanelModel().getObject();
               // logger.debug("restaurant in delete is "+r);
               Restaurant r = (Restaurant)  getContainingPage().getSelectedRestaurantModel().getObject();
               logger.debug("restaurant in delete button is "+r);
               getContainingPage().performStateOperation(MaintainRestaurants.STATE.DELETE);
                //   setSelectedRestaurant(new Restaurant());
            }

            @Override
            protected String getOnClickScript() {
                return "return confirm('Remove Restaurant?');";
            }

            @Override
            public boolean isVisible() {
                boolean isVisible = false;

                switch (getContainingPage().getState()) {
                    case ADD:
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

        addDeleteRestaurantForm.add(addButton);
        addDeleteRestaurantForm.add(deleteButton);
        add(addDeleteRestaurantForm);





    }

 
    

    /**
     * @return the containingPage
     */
    public MaintainRestaurants getContainingPage() {
        return (MaintainRestaurants) getParent();
    }
}
