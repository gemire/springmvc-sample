/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.lightbox;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.resources.ResourceMarker;
import static com.dhenton9000.wicket.resources.ResourceMarker.JQUERY_JS;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 *
 * @author dhenton
 */
public final class LightboxPage extends TemplatePage {

    private static final JavaScriptResourceReference PIXDISPLAY_JS =
            new JavaScriptResourceReference(LightboxPage.class, "js/pixDisplay.js");
    private static final CssResourceReference PIXDISPLAY_CSS =
            new CssResourceReference(LightboxPage.class, "css/pixDisplay.css");
    private static final JavaScriptResourceReference INIT_DISPLAY =
            new JavaScriptResourceReference(LightboxPage.class, "js/init_display.js");

    public LightboxPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        add(new Behavior() {
            private static final long serialVersionUID = 1L;

            @Override
            public void renderHead(Component component, IHeaderResponse response) {
                super.renderHead(component, response);
                response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
                response.render(CssReferenceHeaderItem.forReference(PIXDISPLAY_CSS));
                response.render(JavaScriptReferenceHeaderItem.forReference(PIXDISPLAY_JS));
                response.render(JavaScriptReferenceHeaderItem.forReference(INIT_DISPLAY));
            }
        });

        init();
    }

// this can be used as well, but it doesn't allow a way of defining in a single
// block of code how to add a given set of css or js resources. The behavior
// above could be pulled out publicly to encapsulate the collection of 
// items to add to the head and be reused in other pages. 
// Otherwise you have to have the same line of code in all your pages
    
//    @Override
//    public void renderHead(IHeaderResponse response) {
//        // the order is important as jquery must exist before pixDisplay
//        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
//        response.render(CssReferenceHeaderItem.forReference(PIXDISPLAY_CSS));
//        response.render(JavaScriptReferenceHeaderItem.forReference(PIXDISPLAY_JS));
//        response.render(JavaScriptReferenceHeaderItem.forReference(INIT_DISPLAY));
//    }

    private void init() {
        // ExternalLink a1Link = createPixDisplayLink("a1");



        add(createPixDisplayLink("a1"));
        add(createPixDisplayLink("a2"));
        add(createPixDisplayLink("a3"));
        add(createPixDisplayLink("a4"));
        add(createPixDisplayLink("a5"));
        add(createPixDisplayLink("a6"));
        add(createPixDisplayLink("a7"));
        add(createPixDisplayLink("a8"));

    }

    private ExternalLink createPixDisplayLink(String imgValue) {
        ResourceReference imagesResourceReference =
                new PackageResourceReference(LightboxPage.class, "images/" + imgValue + ".jpg");
        //  PageParameters imageParameters = new PageParameters();
        CharSequence urlForImage = getRequestCycle().urlFor(imagesResourceReference, null);
        ExternalLink a1Link = new ExternalLink(imgValue + "_link", urlForImage.toString());
        a1Link.add(new Image(imgValue + "_thumb",
                new PackageResourceReference(LightboxPage.class, "images/" + imgValue + "_thumb.jpg")));
        return a1Link;
    }
}
