/*
 * Application.java
 *
 * Created on December 3, 2012, 9:50 AM
 */
package com.dhenton9000.wicket;

import com.dhenton9000.wicket.jpa.JPAServiceStarter;
import com.google.inject.Injector;
import org.apache.wicket.guice.GuiceComponentInjector;
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

    @Override
    public Class getHomePage() {
        
        return HomePage.class;
    }
    // Injector.get().inject(this) -- use this is a class constructor 
    // to get it to be wired by Guice, cannot use constructor injection 
    @Override
    public void init()
    {
        super.init();
        
       // getComponentInstantiationListeners().add(new GuiceComponentInjector(this));
        
        Injector injector = (Injector)getServletContext().getAttribute(Injector.class.getName());
        getComponentInstantiationListeners().add(new GuiceComponentInjector(this,injector));
        // start the JPA session thing
        injector.getInstance(JPAServiceStarter.class);
    }
    
}
