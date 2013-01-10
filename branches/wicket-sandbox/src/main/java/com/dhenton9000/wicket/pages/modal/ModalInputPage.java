/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.modal;

import com.dhenton9000.wicket.pages.TemplatePage;
import java.io.Serializable;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a demonstration of passing information to a modal dialog
 * and getting it back.
 * 
 * @author dhenton
 */
public final class ModalInputPage extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(ModalInputPage.class);
    private ChooserPanel chooserPanel;
    private Form<ModalData> form = null;
    private ModalData formData = new ModalData();

    public ModalInputPage() {
        super();
        setup();
    }

    public ModalInputPage(PageParameters params) {
        setup();
    }

    public void setup() {
        setPageTitle(getClass().getSimpleName());
        form = new Form<ModalData>("form", new CompoundPropertyModel(
                new PropertyModel(ModalInputPage.this, "formData"))) {
            @Override
            protected void onSubmit() {
                logger.debug("form submitted.");
            }
        };
        form.setOutputMarkupId(true);
        add(form);
        form.add(new Label("ageLabel", "Age"));
        form.add(new Label("nameLabel", "Name"));
        TextField ageField = new TextField("age");
        form.add(ageField);
        TextField nameField = new TextField("name");
        form.add(nameField);
        form.add(new Button("button"));

        final ModalWindow chooserWindow = new ModalWindow("chooserWindow");
        chooserWindow.setOutputMarkupId(true);
        chooserWindow.setInitialWidth(200);
        chooserWindow.setInitialWidth(350);
        add(chooserWindow);
        // the CompounPropertyModel will allow the use of reflection
        // to fill out the form elements in the html based off the object
        // the property model means that the property will be evaluated each
        // time in the cycle, thus reflecting updates
        
        chooserPanel = new ChooserPanel(chooserWindow.getContentId(),
                new CompoundPropertyModel(
                new PropertyModel(ModalInputPage.this, "formData")));

        chooserWindow.setContent(chooserPanel);
        chooserWindow.setTitle("Enter Your Data");
        // to remember window positioning
        chooserWindow.setCookieName("chooserWindow-1");

        chooserWindow.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {
            @Override
            public boolean onCloseButtonClicked(AjaxRequestTarget target) {
                // this does nothing, and since the form wasn't modified
                // in the dialog, nothing will change on this form
                return true;
            }
        });

        chooserWindow.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget target) {

                target.add(form);


            }
        });

        form.add(new AjaxLink("chooserLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                chooserWindow.show(target);
            }
        });

    }

    /**
     * @return the formData
     */
    public ModalData getFormData() {
        return formData;
    }

    /**
     * @param formData the formData to set
     */
    public void setFormData(ModalData formData) {
        this.formData = formData;
    }

    /**
     * the form 'backing bean' if you will
     */
    public class ModalData implements Serializable{

        private String name = "[Type Name]";
        private Integer age = 25;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public Integer getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
