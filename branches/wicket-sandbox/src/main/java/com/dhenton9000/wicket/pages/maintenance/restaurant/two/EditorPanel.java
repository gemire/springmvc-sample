/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant.two;

import com.dhenton9000.jpa.entities.Restaurant;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class EditorPanel extends Panel {

    private Form<Restaurant> mainEditForm = null;
    private TextField nameField;
    private FeedbackPanel feedbackPanel;
    private final Logger logger = LoggerFactory.getLogger(EditorPanel.class);
    private Button submitButton;
    private Button cancelButton;
    private Button deleteButton;

    private enum BUTTON_ACTION {

        SAVE, CANCEL, DELETE
    };
    private BUTTON_ACTION buttonAction = BUTTON_ACTION.SAVE;

    /**
     * the model is a compound property model around a property model
     *
     * @param id
     * @param model
     * @param service
     */
    public EditorPanel(String id, IModel model) {
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

        INullAcceptingValidator versionValidator =
                new INullAcceptingValidator() {
                    @Override
                    public void validate(IValidatable validatable) {
                        logger.debug("in validate version ");
                        if (validatable != null && buttonAction.equals(BUTTON_ACTION.SAVE)
                                && (validatable.getValue() == null || validatable.getValue().toString().equals(""))) {



                            validatable.error(new IValidationError() {
                                @Override
                                public String getErrorMessage(IErrorMessageSource messageSource) {
                                    return "Version required";
                                }
                            });
                        }
                        if (buttonAction.equals(BUTTON_ACTION.SAVE)) {

                            boolean isNumber = true;
                            final String versionString = (String) validatable.getValue();
                            logger.debug("evaling " + versionString);
                            Integer i = null;
                            try {
                                i = Integer.parseInt(versionString);
                            } catch (Exception err) {
                                isNumber = false;
                                logger.debug("failed parse");
                            }
                            if (!isNumber) {
                                logger.debug("writing error ");
                                validatable.error(new IValidationError() {
                                    @Override
                                    public String getErrorMessage(IErrorMessageSource messageSource) {
                                        return "'" + versionString + "' is not a number";
                                    }
                                });
                            }

                        }
                    }
                };



        mainEditForm = new Form<Restaurant>("restaurantForm", new CompoundPropertyModel(model)) {
            @Override
            protected void onSubmit() {

                Restaurant modelObject = getModelObject();
                RestaurantEvent eV = new RestaurantEvent();

                switch (buttonAction) {
                    case SAVE:
                        eV.setRequest(RestaurantEvent.REQUEST.SAVE_REQUEST);
                        eV.setRestaurant(modelObject);

                        break;
                    case CANCEL:
                        eV.setRequest(RestaurantEvent.REQUEST.CANCEL_REQUEST);
                        break;

                    case DELETE:
                        eV.setRequest(RestaurantEvent.REQUEST.DELETE_REQUEST);
                        eV.setRestaurant(modelObject);
                        break;

                }
                send(getPage(), Broadcast.DEPTH, eV);


            }

            @Override
            public void process(IFormSubmitter submittingComponent) {
                if (submittingComponent == cancelButton) {
                    buttonAction = BUTTON_ACTION.CANCEL;
                }
                if (submittingComponent == submitButton) {
                    buttonAction = BUTTON_ACTION.SAVE;
                }
                if (submittingComponent == deleteButton) {
                    buttonAction = BUTTON_ACTION.DELETE;
                }
                logger.debug("in process " + buttonAction);
                super.process(submittingComponent);
            }
        };
        TextField zipCodeField = new TextField("zipCode");
        mainEditForm.add(zipCodeField);
        TextField versionField = new TextField("versionString");
        versionField.add(versionValidator);
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
            }
        };


        deleteButton = new Button("deleteButton", new Model("Delete")) {
            @Override
            public void onSubmit() {
            }

            @Override
            protected String getOnClickScript() {
                return "return confirm('Remove Restaurant?');";
            }
        };




        mainEditForm.add(cancelButton);
        mainEditForm.add(deleteButton);
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

    public void resetMainForm() {
        mainEditForm.clearInput();
    }

    public MaintainRestaurantsTwo getContainingPage() {
        return (MaintainRestaurantsTwo) getParent();
    }
}
