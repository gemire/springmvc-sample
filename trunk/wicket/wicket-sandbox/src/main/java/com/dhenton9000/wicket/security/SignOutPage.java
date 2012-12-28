/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security;

import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.Page;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class SignOutPage extends TemplatePage {

    public static final String REDIRECTPAGE_PARAM = "redirectpage";

    public SignOutPage() {
        super();
        this.setPageTitle(this.getClass().getSimpleName());
        
    }

    public SignOutPage(PageParameters parameters) {
        String page = parameters.get(REDIRECTPAGE_PARAM).toString();
        Class<? extends Page> pageClass;

        if (page != null) {
            try {

                pageClass = (Class<? extends Page>) Class.forName(page);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            pageClass = getApplication().getHomePage();
        }
        getSession().invalidate();
        setResponsePage(pageClass);

    }
}
