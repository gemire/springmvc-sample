/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.panels;

import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 *
 * @author dhenton
 */
public final class SamplePanelPage extends TemplatePage {

    public SamplePanelPage() {
        super();
        setup();
    }
    
    public SamplePanelPage(PageParameters params) {
       setup();
    }
    
    private void setup()
    {
        add(new SamplePanel("panel"));
    }
}
