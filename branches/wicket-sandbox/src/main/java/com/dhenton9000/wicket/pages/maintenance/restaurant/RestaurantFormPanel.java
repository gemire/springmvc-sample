/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class RestaurantFormPanel extends Panel {

    private IRestaurantDao service;
    private Form<Restaurant> mainEditForm = null;
    private TextField nameField;
    private FeedbackPanel feedbackPanel;
    private final Logger logger = LoggerFactory.getLogger(RestaurantFormPanel.class);

    private enum BUTTON_ACTION {

        SAVE, CANCEL
    }
    private BUTTON_ACTION buttonAction = BUTTON_ACTION.SAVE;

    /**
     * the model is a compound property model around a property model
     *
     * @param id
     * @param model
     * @param service
     */
    public RestaurantFormPanel(String id, IModel model, final IRestaurantService service) {
        super(id, model);



        mainEditForm = new Form<Restaurant>("restaurantForm", model) {
            @Override
            protected void onSubmit() {
                if (buttonAction.equals(BUTTON_ACTION.SAVE)) {
                    String name =  nameField.getDefaultModelObjectAsString();
                    logger.debug("name is "+name);
                    if (name != null && name.length() > 0) {
                        Restaurant modelObject = getModelObject();
                        if (modelObject.isPrimaryKeySet() == false)
                        {
                            service.save(modelObject);
                        }
                        else
                        {
                            service.merge(modelObject);
                        }
                        
                        getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);
                        info("Changes saved!");

                    } else {
                        error("Restaurant Name cannot be empty");
                        //state stays the same
                    }
                } else {
                    // cancel
                    buttonAction = BUTTON_ACTION.SAVE;
                    getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);

                }
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
        nameField = new TextField("name");
        mainEditForm.add(nameField);
        TextField stateField = new TextField("state");
        mainEditForm.add(stateField);
        Label idLabel = new Label("id");
        mainEditForm.add(idLabel);
        mainEditForm.add(new Button("submitButton", new Model("Save Edits")));
        add(mainEditForm);
        feedbackPanel = new FeedbackPanel("feedbackForEditForm");
        add(feedbackPanel);


        // Form cancelForm = new Form("cancelForm");
        Button cancelButton = new Button("cancelButton", new Model("Cancel")) {
            @Override
            public void onSubmit() {
                buttonAction = BUTTON_ACTION.CANCEL;
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

        // cancelForm.add(cancelButton);
        // add(cancelForm);
        mainEditForm.add(cancelButton);

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

    public void resetMainForm() {
        mainEditForm.clearInput();
    }
}
