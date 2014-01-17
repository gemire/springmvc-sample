/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.nested;

import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.pages.form.explore.ExplorePanel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This will be an edit form that will enter managers and associate them with
 * restaurants that they control
 *
 *
 * @author dhenton
 */
public class NestedFormPage extends TemplatePage {

    @SpringBean
    private IRestaurantService service;
    private IModel managerModel;
    private Manager manager = new Manager();
    private final Logger logger = LoggerFactory.getLogger(NestedFormPage.class);
    
    
    public NestedFormPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        managerModel = new CompoundPropertyModel<Manager>(manager);
        manager.setName("fred");
        manager.setPhone("phone");
        createComponents();

    }

    private void createComponents() {
        Form<Manager> managerForm = new Form<Manager>("managerForm", managerModel) {
            @Override
            protected void onSubmit() {
                info("outer hit");
                super.onSubmit();
            }
        };
 
        TextField nameField = new TextField("name");
        managerForm.add(nameField);
        TextField phoneField = new TextField("phone");
        managerForm.add(phoneField);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
        managerForm.add(feedbackPanel);
        Button submitButton = new Button("submitButton", new Model("Save Manager"));
        managerForm.add(submitButton);
        RestaurantSelectForm selectForm = new RestaurantSelectForm(this.service);
        managerForm.add(selectForm.getRoleForm());
       add(managerForm);


    }//end create components
}
