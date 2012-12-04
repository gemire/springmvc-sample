/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket;

import com.dhenton9000.wicket.form.sample.UserPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public final class NavPanel extends TemplatePanel {

    /**
     * Construct.
     *
     * @param id component id
     */
    public NavPanel(String id) {
        super(id);
        configureComponents();
    }

    /**
     * Construct.
     *
     * @param id component id
     * @param model the model
     */
    public NavPanel(String id, IModel<?> model) {
        super(id, model);
        configureComponents();
    }

    private void configureComponents() {
        add(new BookmarkablePageLink<Void>("page1Link", Page1.class));
        add(new BookmarkablePageLink<Void>("page2Link", Page2.class));
        add(new BookmarkablePageLink<Void>("homeLink", HomePage.class));
        add(new BookmarkablePageLink<Void>("userFormLink", UserPage.class));
    }
}
