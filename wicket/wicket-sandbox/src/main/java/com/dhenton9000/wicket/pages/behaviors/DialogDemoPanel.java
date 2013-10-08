/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class DialogDemoPanel extends Panel {

    private final Logger logger = LoggerFactory.getLogger(DialogDemoPanel.class);
    private static final long serialVersionUID = 1L;
    private Form<DialogDemoModel> form;

    public DialogDemoPanel(String id, IModel model) {


        super(id, model);
        //  }
        //  public ChooserPanel(String id) {
        //      super(id);

        final WebMarkupContainer parent = new WebMarkupContainer("demoPanel");
        parent.setOutputMarkupId(true);
        add(parent);
        form = new Form<DialogDemoModel>("demoPanelForm", model) {
            @Override
            protected void onSubmit() {
                // noop the standard submit process
            }
        };
        TextField ageField = new TextField("age");
        form.add(ageField);
        TextField nameField = new TextField("name");
        form.add(nameField);
        TextField occupationField = new TextField("occupation");
        form.add(occupationField);

        parent.add(form);
        form.add(new AjaxButton("button") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {
                // this submits the form, and since the data in the form
                // is also the data in the calling window, modifications here
                // will be reflected in the calling pages form
                ModalWindow.closeCurrent(target);
            }
        });

    }

    /**
     * @return the form
     */
    public Form<DialogDemoModel> getForm() {
        return form;
    }
}
