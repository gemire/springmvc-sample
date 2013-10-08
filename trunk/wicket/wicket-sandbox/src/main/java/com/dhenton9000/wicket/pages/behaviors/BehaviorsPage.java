/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * http://akttech.blogspot.com/2010/02/wicket-page-add-onloadafter-dom-is.html
 *
 * @author dhenton
 */
public final class BehaviorsPage extends TemplatePage {

    private final JavaScriptResourceReference BEHAVIORS_JS =
            new JavaScriptResourceReference(BehaviorsPage.class, "behaviors.js");
    
    private List<DialogDemoModel> dialogItems = new ArrayList<DialogDemoModel>();

    public BehaviorsPage() {
        super();

        setPageTitle(getClass().getSimpleName());
        setUpFlyout();
        
        
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

    private void setUpFlyout() {

       DialogDemoModel demo = null;
   
       demo = new DialogDemoModel("Fred",23,"truck driver");
       getDialogItems().add(demo); 
       demo = new DialogDemoModel("Ted",29,"dental inebriator");
       getDialogItems().add(demo);
     
       DialogDriveListView d = new DialogDriveListView("personView",dialogItems);
       add(d);
    }

    /**
     * @return the dialogItems
     */
    public List<DialogDemoModel> getDialogItems() {
        return dialogItems;
    }

    /**
     * @param dialogItems the dialogItems to set
     */
    public void setDialogItems(List<DialogDemoModel> dialogItems) {
        this.dialogItems = dialogItems;
    }
    
}
