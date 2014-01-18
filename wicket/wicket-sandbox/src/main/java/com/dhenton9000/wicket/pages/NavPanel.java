/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages;

import com.dhenton9000.wicket.pages.ajax.AjaxFormPage;
import com.dhenton9000.wicket.pages.ajax.indicators.AjaxIndicatorPage;
import com.dhenton9000.wicket.pages.behaviors.BehaviorsPage;
import com.dhenton9000.wicket.pages.data.ApplicationsUsers;
import com.dhenton9000.wicket.pages.data.DataPaging;
import com.dhenton9000.wicket.pages.data.sort.DataFilteringPage;
import com.dhenton9000.wicket.pages.events.SimpleEventPage;
import com.dhenton9000.wicket.pages.form.complex.ComplexFormPage;
import com.dhenton9000.wicket.pages.form.explore.ExploreFormPage;
import com.dhenton9000.wicket.pages.form.nested.NestedFormPage;
import com.dhenton9000.wicket.pages.form.sample.CompoundUserPage;
import com.dhenton9000.wicket.pages.form.sample.UserPage;

import com.dhenton9000.wicket.pages.maintenance.security.MaintainApplications;
import com.dhenton9000.wicket.pages.maintenance.restaurant.two.MaintainRestaurantsTwo;
import com.dhenton9000.wicket.pages.modal.ModalInputPage;
import com.dhenton9000.wicket.pages.onhover.OnHoverPage;
import com.dhenton9000.wicket.pages.repeater.FormInputWithList;
import com.dhenton9000.wicket.pages.repeater.SimpleListViewRepeater;
import com.dhenton9000.wicket.pages.lightbox.LightboxPage;
import com.dhenton9000.wicket.pages.subclass.PageSwapDemo;
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
        add(new BookmarkablePageLink<Void>("modalInputPageLink", ModalInputPage.class));
        add(new BookmarkablePageLink<Void>("lightBoxPageLink", LightboxPage.class));
        add(new BookmarkablePageLink<Void>("simpleEventPageLink", SimpleEventPage.class));
        add(new BookmarkablePageLink<Void>("exploreFormPageLink", ExploreFormPage.class));
        add(new BookmarkablePageLink<Void>("maintainRestaurantsTwoLink", MaintainRestaurantsTwo.class));
        add(new BookmarkablePageLink<Void>("onHoverPageLink", OnHoverPage.class));
        add(new BookmarkablePageLink<Void>("ajaxFormPageLink", AjaxFormPage.class));
        add(new BookmarkablePageLink<Void>("behaviorsPageLink", BehaviorsPage.class));
        add(new BookmarkablePageLink<Void>("dataPagingLink", DataPaging.class));
        add(new BookmarkablePageLink<Void>("dataFilteringLink", DataFilteringPage.class));
        add(new BookmarkablePageLink<Void>("pageSwapDemoPageLink", PageSwapDemo.class));
        add(new BookmarkablePageLink<Void>("ajaxIndicatorPageLink", AjaxIndicatorPage.class));
        add(new BookmarkablePageLink<Void>("nestedFormPageLink", NestedFormPage.class));
        add(new BookmarkablePageLink<Void>("complexFormPageLink", ComplexFormPage.class));
       
        // this isn't needed see Application.java for a mount 
        // that allows for a more normal url
        // add(new BookmarkablePageLink<Void>("refPageLink", ImageRefPage.class));
    }
}
