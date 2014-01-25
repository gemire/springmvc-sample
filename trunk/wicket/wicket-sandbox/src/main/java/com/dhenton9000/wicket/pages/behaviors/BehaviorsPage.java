/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://akttech.blogspot.com/2010/02/wicket-page-add-onloadafter-dom-is.html
 *
 * @author dhenton
 */
public final class BehaviorsPage extends TemplatePage {

    private final JavaScriptResourceReference BEHAVIORS_JS =
            new JavaScriptResourceReference(BehaviorsPage.class, "behaviors.js");
    private List<DialogDemoModel> dialogItems = new ArrayList<DialogDemoModel>();
    private DialogDemoPanel dialogDemoPanel = null;
    private DialogDemoModel newDemoData = new DialogDemoModel();
    private WebMarkupContainer listViewContainer;
    private Logger logger = LoggerFactory.getLogger(BehaviorsPage.class);
    private boolean addedNewItem = true;

    public BehaviorsPage() {
        super();

        setPageTitle(getClass().getSimpleName());
        setUpFlyout();


    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(JavaScriptReferenceHeaderItem.forReference(BEHAVIORS_JS));
        String script = "var myDataString = '" + (new Date()).toString() + "';";
        String id = "dateElementScript";
        String myReadyScript = "$('#inputVar').val('on dom')";
        // this is rendered in the head
        OnDomReadyHeaderItem oHeaderItem = OnDomReadyHeaderItem.forScript(myReadyScript);
        // this is in the on load
        response.render(OnLoadHeaderItem.forScript("$('#inputVar').val('on load '+myDataString)"));
        response.render(JavaScriptReferenceHeaderItem.forScript(script, id));
        response.render(oHeaderItem);
    }

    private void setUpFlyout() {

        DialogDemoModel demo = null;

        demo = new DialogDemoModel("Fred", 23, "truck driver");
        getDialogItems().add(demo);
        demo = new DialogDemoModel("Ted", 29, "dental inebriator");
        getDialogItems().add(demo);
        listViewContainer = new WebMarkupContainer("listViewContainer");
        listViewContainer.setOutputMarkupId(true);
        DialogDriveListView listView = new DialogDriveListView("personView", dialogItems);
        listViewContainer.add(listView);
        add(listViewContainer);


        ///////////////////////////////////////////////////////////////////

        final ModalWindow demoModalWindow = new ModalWindow("demoModalWindow");
        demoModalWindow.setOutputMarkupId(true);
        demoModalWindow.setInitialWidth(400);
        demoModalWindow.setInitialHeight(250);
        add(demoModalWindow);

        dialogDemoPanel = new DialogDemoPanel(demoModalWindow.getContentId(),
                new CompoundPropertyModel(
                new PropertyModel(BehaviorsPage.this, "newDemoData")));

        demoModalWindow.setContent(dialogDemoPanel);
        demoModalWindow.setTitle("Enter Your Data");
        // to remember window positioning
        demoModalWindow.setCookieName("demoModalWindow-1");

        demoModalWindow.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {
            @Override
            public boolean onCloseButtonClicked(AjaxRequestTarget target) {
                // this does nothing, and since the form wasn't modified
                // in the dialog, nothing will change on this form
                logger.info("hit the x");

                addedNewItem = false;
                return true;
            }
        });

        demoModalWindow.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget target) {

                //TODO: move the contents of newDemoData to the list
                //TODO: zero out newDemoData
                logger.info("in onwindow closed");

                DialogDemoModel sDemo = (DialogDemoModel) dialogDemoPanel.getForm().getDefaultModelObject();

                logger.info("name is " + sDemo.getName());

                if (addedNewItem) {
                    getDialogItems().add(newDemoData);
                }
                newDemoData = new DialogDemoModel();
                addedNewItem = true;
                target.add(listViewContainer);


            }
        });

        add(new AjaxLink("enterDataLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                demoModalWindow.show(target);
            }
        });


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
