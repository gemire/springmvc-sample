/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.lightbox;

import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
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
    public static final JavaScriptResourceReference JQUERY_JS =
            new JavaScriptResourceReference(LightboxPage.class, "js/jquery-1.6.2.min.js");
    private static final CssResourceReference PIXDISPLAY_CSS =
            new CssResourceReference(LightboxPage.class, "css/pixDisplay.css");
    private static final JavaScriptResourceReference INIT_DISPLAY =
            new JavaScriptResourceReference(LightboxPage.class, "js/init_display.js");

    public LightboxPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        init();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        // the order is important as jquery must exist before pixDisplay
        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
        response.render(CssReferenceHeaderItem.forReference(PIXDISPLAY_CSS));
        response.render(JavaScriptReferenceHeaderItem.forReference(PIXDISPLAY_JS));
        response.render(JavaScriptReferenceHeaderItem.forReference(INIT_DISPLAY));
    }

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
