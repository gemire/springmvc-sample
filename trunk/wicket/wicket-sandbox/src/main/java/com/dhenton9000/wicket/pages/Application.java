/*
 * Application.java
 *
 * Created on December 3, 2012, 9:50 AM
 */
package com.dhenton9000.wicket.pages;

import com.dhenton9000.wicket.jpa.JPAServiceStarter;
import com.dhenton9000.wicket.refs.ImageRefPage;
import com.dhenton9000.wicket.refs.ImageResourceReference;
import com.dhenton9000.wicket.pages.security.AuthenticatedWebPage;
import com.dhenton9000.wicket.pages.security.SandboxSession;
import com.dhenton9000.wicket.pages.security.SignIn;
import com.google.inject.Injector;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestableComponent;
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
    // Injector.get().inject(this) -- use this in a class constructor 
    // to get it to be wired by Guice, cannot use constructor injection 

    @Override
    public void init() {
        super.init();
        // this is for the generated image in demo in ImageRefPage.java
        mountResource("/images/${name}", new ImageResourceReference());
        // this cleans up the url http://localhost:9090/wicket-sandbox/imagesPage?0
        // will go to the ImageRefPage
        mountPage("imagesPage", ImageRefPage.class);
        ////////////////////

        // Register the authorization strategy
        getSecuritySettings().setAuthorizationStrategy(new IAuthorizationStrategy() {
            @Override
            public boolean isActionAuthorized(Component component, Action action) {
                // authorize everything
              //  logger.debug("authorizing for component " + component.getMarkupId() + " action " + action.getName());
                return true;
            }

            @Override
            public <T extends IRequestableComponent> boolean isInstantiationAuthorized(
                    Class<T> componentClass) {
                // Check if the new Page requires authentication (implements the marker interface)
               // logger.debug("entering isInstantiationAuthorized " + componentClass.getSimpleName());
                if (AuthenticatedWebPage.class.isAssignableFrom(componentClass)) {
                    // Is user signed in?
                    if (((SandboxSession) Session.get()).isAuthenticated()) {
                        // okay to proceed
                    //    logger.debug("authenticated hit " + componentClass.getSimpleName());
                        return true;
                    }
                   // logger.debug("about to throw noauth " + componentClass.getSimpleName());

                    // Intercept the request, but remember the target for later.
                    // Invoke Component.continueToOriginalDestination() after successful logon to
                    // continue with the target remembered.

                    throw new RestartResponseAtInterceptPageException(SignIn.class);
                }

                // okay to proceed
                return true;
            }
        });

        ///////////////////

        // getComponentInstantiationListeners().add(new GuiceComponentInjector(this));

        Injector injector = (Injector) getServletContext().getAttribute(Injector.class.getName());
        getComponentInstantiationListeners().add(new GuiceComponentInjector(this, injector));
        // start the JPA session thing
        injector.getInstance(JPAServiceStarter.class);
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new SandboxSession(request);
    }
}
