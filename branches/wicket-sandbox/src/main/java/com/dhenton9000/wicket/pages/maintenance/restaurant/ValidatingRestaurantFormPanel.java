/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant;

import com.dhenton9000.wicket.pages.form.explore.*;
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.pages.maintenance.restaurant.MaintainRestaurants;
import java.io.Serializable;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.form.IFormSubmittingComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class ValidatingRestaurantFormPanel extends Panel {

    private IRestaurantDao service;
    private Form<Restaurant> mainEditForm = null;
    private TextField nameField;
    private FeedbackPanel feedbackPanel;
    private final Logger logger = LoggerFactory.getLogger(ExplorePanel.class);
    private Button submitButton;
    private Button cancelButton;
    

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
    public ValidatingRestaurantFormPanel(String id, IModel model, final IRestaurantService service) {
        super(id, model);
        
        logger.debug("restaurant form panel " + model.getObject().toString());


        // this will send a null in, IValidator will not
        INullAcceptingValidator nameValidator =
                new INullAcceptingValidator() {
                    @Override
                    public void validate(IValidatable validatable) {
                        logger.debug("in validate");
                        if (validatable != null && buttonAction.equals(BUTTON_ACTION.SAVE)
                                && (validatable.getValue() == null || validatable.getValue().toString().equals(""))) {

                            logger.debug("hit error " + buttonAction);

                            validatable.error(new IValidationError() {
                                @Override
                                public String getErrorMessage(IErrorMessageSource messageSource) {
                                    return "Name Required, moron!";
                                }
                            });
                        }
                    }
                };


        mainEditForm = new Form<Restaurant>("restaurantForm", new CompoundPropertyModel(model)) {
            @Override
            protected void onSubmit() {


                doSave();


            }

            @Override
            public void process(IFormSubmitter submittingComponent) {
                if (submittingComponent == cancelButton) {
                    buttonAction = BUTTON_ACTION.CANCEL;
                } else {
                    buttonAction = BUTTON_ACTION.SAVE;
                }
                logger.debug("in process " + buttonAction);
                super.process(submittingComponent);
            }

            private void doSave() {
                Restaurant modelObject = getModelObject();
                logger.debug("before merge/add submit " + modelObject);
                if (modelObject.isPrimaryKeySet() == false) {
                    logger.debug("in on submit save " + modelObject.toString());

                    service.save(modelObject);
                } else {
                    logger.debug("in on submit merge " + modelObject.toString());

                    //  List<Restaurant> t = service.find(modelObject);
                    // Restaurant t0 = t.get(0);
                    // t0.setName(t0.getName()+"zzz");
                    service.merge(modelObject);
                }
                 getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);
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
        nameField.add(nameValidator);
        TextField stateField = new TextField("state");
        mainEditForm.add(stateField);
        submitButton = new Button("submitButton", new Model("Save Edits"));
        // Label idLabel = new Label("idDisplay");
        // mainEditForm.add(idLabel);
        mainEditForm.add(submitButton);
        add(mainEditForm);
        feedbackPanel = new FeedbackPanel("feedbackForEditForm");
        add(feedbackPanel);
       // Restaurant r = (Restaurant) this.getDefaultModel();
        
        Label idField = new Label("id");
        mainEditForm.add(idField);
        cancelButton = new Button("cancelButton", new Model("Cancel")) {
            @Override
            public void onSubmit() {
                
                 getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);
                
            }
        };


        mainEditForm.add(cancelButton);

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
