/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security;

import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public class UserPanel extends Panel {

    public UserPanel(String id, Class<? extends Page> logoutPageClass) {
        super(id);
        add(new Label("fullname",
                new PropertyModel(this, "session.user.fullName")));

        PageParameters parameters = new PageParameters();
        parameters.add(SignOutPage.REDIRECTPAGE_PARAM, logoutPageClass.getName());

        add(new BookmarkablePageLink("signout", SignOutPage.class, parameters) {
            @Override
            public boolean isVisible() {
                return SandboxSession.get().isAuthenticated();
            }
        });
        add(new Link("signin") {
            @Override
            public void onClick() {
                
                throw new RestartResponseAtInterceptPageException(SignIn.class);
            }

            @Override
            public boolean isVisible() {
                
                return !SandboxSession.get().isAuthenticated();
            }
        });


    }
}
