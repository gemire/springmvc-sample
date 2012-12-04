/*
 * Application.java
 *
 * Created on December 3, 2012, 9:50 AM
 */
package com.dhenton9000.wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 * @version
 */
public class Application extends WebApplication {

    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public Application() {
       
    }

    public Class getHomePage() {
        
        return HomePage.class;
    }
}
