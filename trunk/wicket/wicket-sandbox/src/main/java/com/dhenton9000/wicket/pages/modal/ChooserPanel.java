/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.modal;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author dhenton
 */
public class ChooserPanel extends Panel {

    private static final long serialVersionUID = 1L;
    private List<ChooserItem> availItems = Arrays.asList(
            new ChooserItem("I1", "Item 1"),
            new ChooserItem("I2", "Item 2"),
            new ChooserItem("I2", "Item 3"));
    private CheckBoxMultipleChoice checkBoxMultipleChoice;

    public IModel getSelectedModel() {
        return checkBoxMultipleChoice.getModel();
    }

    public ChooserPanel(String id, IModel model, final ModalWindow window) {  
        
        // use this to pass in the model that will be modified by this
        // popup.
        super(id, model);
    }
    public ChooserPanel(String id, final ModalWindow window) {
        super(id);

        final WebMarkupContainer parent = new WebMarkupContainer("chooser");
        parent.setOutputMarkupId(true);
        add(parent);

        Form form = new Form("chooserForm") {
            @Override
            protected void onSubmit() {
                System.out.println("chooseForm submitted.");
            }
        };
        parent.add(form);
        checkBoxMultipleChoice = new CheckBoxMultipleChoice("itemselection", availItems, new ChoiceRenderer("name", "id"));

        form.add(checkBoxMultipleChoice);
        form.add(new AjaxButton("button") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

                window.close(target);
            }
        });

    }

    public class ChooserItem implements Serializable {

        private String id, name;

        public ChooserItem(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
