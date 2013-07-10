/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.resources;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 *
 * @author dhenton
 */
public class ResourceMarker {
        public static final JavaScriptResourceReference JQUERY_JS =
            new JavaScriptResourceReference(ResourceMarker.class, "jquery-1.6.2.min.js");

}
