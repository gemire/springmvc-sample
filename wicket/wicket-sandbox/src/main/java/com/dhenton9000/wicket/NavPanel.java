/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket;

import com.dhenton9000.wicket.guice.GuicePage;
import com.dhenton9000.wicket.guice.data.ApplicationsUsers;
import com.dhenton9000.wicket.guice.data.GuiceRepeaterOne;
import com.dhenton9000.wicket.guice.repeater.SimpleListViewRepeater;
import com.dhenton9000.wicket.pages.form.sample.CompoundUserPage;
import com.dhenton9000.wicket.pages.form.sample.UserPage;
import com.dhenton9000.wicket.refs.RefPage;
import com.dhenton9000.wicket.security.SignIn;
import com.dhenton9000.wicket.security.maintenance.MaintainApplications;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
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
        add(new BookmarkablePageLink<Void>("compoundFormLink", CompoundUserPage.class));
        add(new BookmarkablePageLink<Void>("guicePageLink", GuicePage.class));
        add(new BookmarkablePageLink<Void>("guiceRepeaterOnePageLink", GuiceRepeaterOne.class));
        add(new BookmarkablePageLink<Void>("applicationsUsersLink", ApplicationsUsers.class));
        add(new BookmarkablePageLink<Void>("simpleListViewRepeaterLink", SimpleListViewRepeater.class));
        add(new BookmarkablePageLink<Void>("maintainApplicationsLink", MaintainApplications.class));
        add(new BookmarkablePageLink<Void>("refPageLink", RefPage.class));
    }
}
