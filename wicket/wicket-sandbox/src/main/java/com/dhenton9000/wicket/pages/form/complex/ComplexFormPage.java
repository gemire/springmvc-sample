/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.complex;

import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This will be an edit form that will enter managerDTOs and associate them with
 * restaurants that they control
 *
 *
 * @author dhenton
 */
public class ComplexFormPage extends TemplatePage {

    @Override
    public void detachModels() {
        managerDTO.getAvailableRestaurants().detach();
        managerDTO.getCandidateRestaurants().detach();
        managerDTO.getAllRestaurants().detach();
    }

    @SpringBean
    private IRestaurantService service;
    private final IModel managerModel;
    private final ManagerDTO managerDTO;
    private Form<ManagerDTO> managerForm;
    private Button submitButton;

    public enum BUTTON_ACTION {

        SUBMIT, ADD 
    };
    private BUTTON_ACTION buttonAction = BUTTON_ACTION.SUBMIT;
    private final Logger logger = LoggerFactory.getLogger(ComplexFormPage.class);

    public ComplexFormPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        managerDTO = new ManagerDTO(this.service);
        managerModel = new CompoundPropertyModel<ManagerDTO>(managerDTO);
        managerDTO.setName("fred");
        managerDTO.setPhone("phone");
        createComponents();

    }

    private void createComponents() {
        managerForm = new Form<ManagerDTO>("managerForm", managerModel) {
            @Override
            protected void onSubmit() {
                switch (buttonAction) {
                    case SUBMIT:

                        info(this.getModelObject().getCandidateRestaurants());
                        break;
                    case ADD:

                        selectorPanel.refresh(buttonAction);
                        break;
                }

            }

            @Override
            public void process(IFormSubmitter submittingComponent) {
                if (submittingComponent == submitButton) {
                    buttonAction = BUTTON_ACTION.SUBMIT;
                } else {
                    buttonAction = BUTTON_ACTION.ADD;
                }
                super.process(submittingComponent);
            }

        };

        TextField nameField = new TextField("name");
        nameField.add(generalValidator);
        getManagerForm().add(nameField);
        TextField phoneField = new TextField("phone");
        phoneField.setRequired(true);
        phoneField.add(generalValidator);
        getManagerForm().add(phoneField);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
        getManagerForm().add(feedbackPanel);
        submitButton = new Button("submitButton", new Model("Save Manager"));
        getManagerForm().add(submitButton);
        selectorPanel = new RestaurantSelectorPanel("selectorPanel", this);
        getManagerForm().add(selectorPanel);
        add(getManagerForm());

    }//end create components

  
    private RestaurantSelectorPanel selectorPanel;

    /**
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }

    /**
     * @return the managerForm
     */
    public Form<ManagerDTO> getManagerForm() {
        return managerForm;
    }

    INullAcceptingValidator generalValidator
            = new INullAcceptingValidator() {
                @Override
                public void validate(IValidatable validatable) {
                    logger.debug("in validate");
                    if (validatable != null && buttonAction.equals(BUTTON_ACTION.SUBMIT)
                    && (validatable.getValue() == null || validatable.getValue().toString().equals(""))) {

                        logger.debug("hit error " + buttonAction);

                        validatable.error(new IValidationError() {
                            @Override
                            public String getErrorMessage(IErrorMessageSource messageSource) {
                                return " required, moron!";
                            }
                        });
                    }
                }
            };

}
