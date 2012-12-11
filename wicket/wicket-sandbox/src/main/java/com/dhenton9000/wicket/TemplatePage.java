/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dhenton9000.wicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Base page that serves as a template for pages that inherit from it. Doesn't
 * have to be abstract, but was made abstract here to stress the fact that this
 * page is not meant for direct use.
 *
 * @author Eelco Hillenius
 */
public abstract class TemplatePage extends WicketBasePage {

    /**
     * title of the current page.
     */
    private String pageTitle = "(no title)";

    
    
    public TemplatePage(PageParameters param)
    {
        setup();
    }
    
    /**
     * Constructor
     */
    public TemplatePage() {
        setup();
 
    }

    /**
     * Gets the title.
     *
     * @return title
     */
    public final String getPageTitle() {
        return pageTitle;
    }

    /**
     * Sets the title.
     *
     * @param title title
     */
    public final void setPageTitle(String title) {
        pageTitle = title;
    }

    private void setup() {
        // derived classes set use the title setter to actually set 
        // the title
        add(new Label("title", new PropertyModel<String>(this, "pageTitle")));
        // add the panel to the java graph, its location is found
        // in TemplatePage.html with wicket:id = 'navPanel'
        add(new NavPanel("navPanel"));
    }
}