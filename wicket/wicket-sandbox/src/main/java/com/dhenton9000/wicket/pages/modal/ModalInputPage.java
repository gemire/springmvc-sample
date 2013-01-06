/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.modal;

import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class ModalInputPage extends TemplatePage {

    private Object text;
    private Object itemselection;
    private ChooserPanel chooserPanel;
    private TextField textField;

    public ModalInputPage() {
        super();
        setup();
    }

    public ModalInputPage(PageParameters params) {
        setup();
    }

    public void setup() {
        setPageTitle(getClass().getCanonicalName());
        Form form = new Form("form", new CompoundPropertyModel(this)) {
            @Override
            protected void onSubmit() {
                System.out.println("form submitted.");
            }
        };
        add(form);
        form.add(new Label("label", "Item codes"));
        textField = new TextField("text");
        textField.setOutputMarkupId(true);
        form.add(textField);
        form.add(new Button("button"));

        final ModalWindow chooserWindow = new ModalWindow("chooserWindow");
        chooserWindow.setOutputMarkupId(true);
        form.add(chooserWindow);
        chooserPanel = new ChooserPanel(chooserWindow.getContentId(), chooserWindow);

        chooserWindow.setContent(chooserPanel);
        chooserWindow.setTitle("Make your choice");
        chooserWindow.setCookieName("chooserWindow-1");

        chooserWindow.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {
            @Override
            public boolean onCloseButtonClicked(AjaxRequestTarget target) {
                return true;
            }

             
        });

        chooserWindow.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget target) {
                  textField.setModelObject(chooserPanel.getSelectedModel() );
                 target.add(textField);
                
                
            }
        });

        form.add(new AjaxLink("chooserLink") {
            
            @Override
            public void onClick(AjaxRequestTarget target) {
                chooserWindow.show(target);
            }
        });

    }
}
