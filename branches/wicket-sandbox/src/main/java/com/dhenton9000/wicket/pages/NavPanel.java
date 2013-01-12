/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages;

import com.dhenton9000.wicket.pages.data.ApplicationsUsers;
import com.dhenton9000.wicket.pages.events.SimpleEventPage;
import com.dhenton9000.wicket.pages.form.sample.CompoundUserPage;
import com.dhenton9000.wicket.pages.form.sample.UserPage;
import com.dhenton9000.wicket.pages.maintenance.restaurant.MaintainRestaurants;
import com.dhenton9000.wicket.pages.maintenance.security.MaintainApplications;
import com.dhenton9000.wicket.pages.modal.ModalInputPage;
import com.dhenton9000.wicket.pages.repeater.FormInputWithList;
import com.dhenton9000.wicket.pages.repeater.SimpleListViewRepeater;
import com.dhenton9000.wicket.pages.resources.LightboxPage;
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
   
        add(new BookmarkablePageLink<Void>("homeLink", HomePage.class));
        add(new BookmarkablePageLink<Void>("userFormLink", UserPage.class));
        add(new BookmarkablePageLink<Void>("compoundFormLink", CompoundUserPage.class));
        add(new BookmarkablePageLink<Void>("applicationsUsersLink", ApplicationsUsers.class));
        add(new BookmarkablePageLink<Void>("simpleListViewRepeaterLink", SimpleListViewRepeater.class));
        add(new BookmarkablePageLink<Void>("maintainApplicationsLink", MaintainApplications.class));
        add(new BookmarkablePageLink<Void>("refreshingViewLink", FormInputWithList.class));
        add(new BookmarkablePageLink<Void>("modalInputPageLink",ModalInputPage.class));
        add(new BookmarkablePageLink<Void>("maintainRestaurantsLink",MaintainRestaurants.class));
        add(new BookmarkablePageLink<Void>("lightBoxPageLink",LightboxPage.class));
         add(new BookmarkablePageLink<Void>("simpleEventPageLink",SimpleEventPage.class)); 
        
        // this isn't needed see Application.java for a mount 
        // that allows for a more normal url
        // add(new BookmarkablePageLink<Void>("refPageLink", ImageRefPage.class));
    }
}
