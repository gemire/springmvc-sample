/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.resources;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.shared.images.MountSharedImage;
import java.util.Arrays;
import java.util.Locale;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ContextRelativeResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://wicketinaction.com/2011/07/wicket-1-5-mounting-resources/
 *
 * @author dhenton
 */
public final class ImageRefPage extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(ImageRefPage.class);
    private static final String[] IMAGE_NAMES = new String[]{"one", "two", "three"};

    public ImageRefPage() {
        super();

        final ResourceReference imagesResourceReference = new ImageResourceReference();
        final PageParameters imageParameters = new PageParameters();

        this.setPageTitle(this.getClass().getSimpleName());

        // find an image in this package
        add(new Image("securitySchema",
                new PackageResourceReference(ImageRefPage.class,
                "sec_schema.jpg")));

        // find an image outside of the WEB-INF classes directory
        add(new Image("wicketLogo",
                new ContextRelativeResource("/images/shared/wicket-logo.png")));

        // find an image in the shared section which is 
        // com.dhenton9000.wicket.shared.images
        add(new Image("sharedResource", new PackageResourceReference(MountSharedImage.class, "shared/rr1.jpg")));

        ListView<String> listView = new ListView<String>("imageList", Arrays.asList(IMAGE_NAMES)) {
            @Override
            protected void populateItem(ListItem<String> item) {
                String imageName = item.getModelObject();
                imageParameters.set("name", imageName);

                // generates nice looking url (the mounted one) to the current image
                CharSequence urlForWordAsImage = getRequestCycle().urlFor(imagesResourceReference, imageParameters);
                ExternalLink link = new ExternalLink("imageLink", urlForWordAsImage.toString());
                link.setBody(Model.of(imageName));
                item.add(link);

            }
        };
        add(listView);
    }
}
