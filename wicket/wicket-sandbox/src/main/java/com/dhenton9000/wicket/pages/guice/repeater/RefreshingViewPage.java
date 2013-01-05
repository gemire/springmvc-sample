/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.guice.repeater;

 
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class RefreshingViewPage extends TemplatePage {

    public RefreshingViewPage() {
        super();
        setup();
    }
    
    public RefreshingViewPage(PageParameters params) {
        setup();
    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());
        add(new FeedbackPanel("feedback"));
        
    }
}
