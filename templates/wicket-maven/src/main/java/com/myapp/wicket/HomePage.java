/*
 * HomePage.java
 *
 * Created on December 3, 2012, 9:50 AM
 */

package com.myapp.wicket;           

import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends BasePage {

    public HomePage() {
        add(new Label("message", "Hello, World!"));
    }

}
