/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant.two;

import com.dhenton9000.wicket.pages.maintenance.restaurant.MaintainRestaurants;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class AddButtonPanel extends Panel {

    private Form addForm;
    private final Logger logger = LoggerFactory.getLogger(AddButtonPanel.class);

    public AddButtonPanel(String id) {
        super(id);

        addForm = new Form("addForm") {
            @Override
            protected void onSubmit() {

                RestaurantEvent eV =
                        new RestaurantEvent();
                eV.setRequest(RestaurantEvent.REQUEST.ADD_REQUEST);
                send(getPage(), Broadcast.DEPTH, eV);


            }
        };

        addForm.add(addButton);
        add(addForm);


    }
    Button addButton = new Button("addButton", new Model("Add")) {
        @Override
        public void onSubmit() {
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

    public MaintainRestaurantsTwo getContainingPage() {
        return (MaintainRestaurantsTwo) getParent();
    }
}
