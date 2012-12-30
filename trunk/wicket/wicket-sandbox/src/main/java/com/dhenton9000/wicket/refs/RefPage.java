/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.refs;

 
import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class RefPage extends TemplatePage {

    public RefPage() {
        super();
        this.setPageTitle(this.getClass().getSimpleName());
    }
    
    public RefPage(PageParameters params) {
        //TODO:  process page parameters
    }
}
