/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.ajax;

import com.dhenton9000.wicket.dao.impl.ApplicationsDaoImpl;
import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.pages.lightbox.LightboxPage;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.util.string.StringValue;
import com.google.gson.Gson;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import static  com.dhenton9000.wicket.pages.lightbox.LightboxPage.*;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */


public final class AjaxFormPage extends TemplatePage {


    private Form ajaxForm;
    private final TextField firstName;
    private final TextField lastName;
    private final AbstractAjaxBehavior aab1;
    private final Form form2;
    private final TextField state;
    private final AbstractAjaxBehavior aab2;
    private static final JavaScriptResourceReference JQUERY_FORM_JS =
            new JavaScriptResourceReference(AjaxFormPage.class, "js/jquery.form.js");
    private static final JavaScriptResourceReference AJAX_FORM_JS =
            new JavaScriptResourceReference(AjaxFormPage.class, "js/ajaxform.js");
   private final static Logger logger = LoggerFactory.getLogger(AjaxFormPage.class);

    public AjaxFormPage() {
        
        super();
        setPageTitle(getClass().getSimpleName());
        /* Example 1
         * Ajax Behavior provides an event
         * listener as well as the request
         * handler.
         */
        add(aab1 = new AbstractAjaxBehavior() {


            // handle the ajax request
            @Override
            public void onRequest() {
                logger.debug("ajax request received");


                RequestCycle requestCycle = getComponent().getRequestCycle();
                Request request = requestCycle.getRequest();
                IRequestParameters irp = request.getPostParameters();
                StringBuilder sb = new StringBuilder();
                sb.append("firstName: " + irp.getParameterValue("firstName"));
                sb.append(", ");
                sb.append("lastName: " + irp.getParameterValue("lastName"));
                requestCycle.scheduleRequestHandlerAfterCurrent(new TextRequestHandler(sb.toString()));
            }
        });




        /*
         * A form whose action tag will be set to the 
         * above behavior's call back url.
         */
        add(ajaxForm = new Form("form1") {


            // set the form's action tag to the behavior's call back url
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("action", aab1.getCallbackUrl());
            }
        });


        /*
         * Form inputs for first and last name.
         */
        ajaxForm.add(firstName = new TextField("firstName"));


        ajaxForm.add(lastName = new TextField("lastName"));


        /* Example 2
         * Ajax Behavior provides an event
         * listener as well as the request
         * handler.
         */
        add(aab2 = new AbstractAjaxBehavior() {


            // handle the ajax request
            @Override
            public void onRequest() {
                System.out.println("ajax request received");


                RequestCycle requestCycle = getComponent().getRequestCycle();
                Request request = requestCycle.getRequest();
                IRequestParameters irp = request.getPostParameters();
                StringValue state = irp.getParameterValue("state");
                List statesLike = MockDb.getStatesLike(state.toString());
                requestCycle.scheduleRequestHandlerAfterCurrent(new TextRequestHandler(convertListToJson(statesLike)));
            }
        });


        add(form2 = new Form("form2") {


            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("action", aab2.getCallbackUrl());
            }
        });


        form2.add(state = new TextField("state"));
    }


    /*
     * Convert List to json object
     */
    private String convertListToJson(List matches) {
        Gson gson = new Gson();
        String json = gson.toJson(matches);
        return json;
    }

    
     @Override
    public void renderHead(IHeaderResponse response) {
        // the order is important as jquery must exist before pixDisplay
        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_FORM_JS));
        response.render(JavaScriptReferenceHeaderItem.forReference(AJAX_FORM_JS));
    }
    
    

    /*
     * A Mock Database
     */
    static class MockDb {


        private static final String[] states = new String[]{
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming"
        };


        static List getStatesLike(String target) {


            List matches = new ArrayList();
            for (String s : states) {
                if (s.toLowerCase().startsWith(target.toLowerCase())) {
                    matches.add(s);
                }
            }
            return matches;
        }
    };
}






