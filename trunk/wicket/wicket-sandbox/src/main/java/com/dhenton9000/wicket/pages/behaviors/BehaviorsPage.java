/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.Date;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * http://akttech.blogspot.com/2010/02/wicket-page-add-onloadafter-dom-is.html
 *
 * @author dhenton
 */
public final class BehaviorsPage extends TemplatePage {

    private final JavaScriptResourceReference BEHAVIORS_JS =
            new JavaScriptResourceReference(BehaviorsPage.class, "behaviors.js");

    public BehaviorsPage() {
        super();

        setPageTitle(getClass().getSimpleName());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(JavaScriptReferenceHeaderItem.forReference(BEHAVIORS_JS));
        String script = "var myDataString = '"+(new Date()).toString()+"';";
        String id = "dateElementScript";
        String myReadyScript = "$('#inputVar').val('on dom')";
        OnDomReadyHeaderItem oHeaderItem = OnDomReadyHeaderItem.forScript(myReadyScript);
        response.render(OnLoadHeaderItem.forScript("$('#inputVar').val('on load '+myDataString)"));
        response.render(JavaScriptReferenceHeaderItem.forScript(script, id));
        response.render(oHeaderItem);
    }
    
    
    
}
