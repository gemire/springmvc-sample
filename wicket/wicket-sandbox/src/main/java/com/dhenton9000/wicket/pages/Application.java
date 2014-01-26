/*
 * Application.java
 *
 * Created on December 3, 2012, 9:50 AM
 */
package com.dhenton9000.wicket.pages;

import com.dhenton9000.wicket.pages.ajax.AjaxFormPage;
import com.dhenton9000.wicket.pages.ajax.indicators.AjaxIndicatorPage;
import com.dhenton9000.wicket.pages.behaviors.BehaviorsPage;
import com.dhenton9000.wicket.pages.data.ApplicationsUsers;
import com.dhenton9000.wicket.pages.data.DataPaging;
import com.dhenton9000.wicket.pages.data.sort.DataFilteringPage;
import com.dhenton9000.wicket.pages.events.SimpleEventPage;
import com.dhenton9000.wicket.pages.form.complex.ComplexFormPage;
import com.dhenton9000.wicket.pages.form.explore.ExploreFormPage;
import com.dhenton9000.wicket.pages.form.listview.FormListView;
import com.dhenton9000.wicket.pages.form.nested.NestedFormPage;
import com.dhenton9000.wicket.pages.form.sample.CompoundUserPage;
import com.dhenton9000.wicket.pages.form.sample.UserPage;
import com.dhenton9000.wicket.pages.modal.ModalInputPage;
import com.dhenton9000.wicket.pages.resources.ImageRefPage;
import com.dhenton9000.wicket.pages.repeater.FormInputWithList;
import com.dhenton9000.wicket.pages.repeater.SimpleListViewRepeater;
import com.dhenton9000.wicket.pages.security.AuthenticatedWebPage;
import com.dhenton9000.wicket.pages.security.SandboxSession;
import com.dhenton9000.wicket.pages.security.SignIn;
import com.dhenton9000.wicket.pages.maintenance.security.MaintainApplications;
import com.dhenton9000.wicket.pages.maintenance.restaurant.two.MaintainRestaurantsTwo;
import com.dhenton9000.wicket.pages.onhover.OnHoverPage;
import com.dhenton9000.wicket.pages.lightbox.LightboxPage;
import com.dhenton9000.wicket.pages.resources.ImageResourceReference;
import com.dhenton9000.wicket.pages.security.SignOutPage;
import com.dhenton9000.wicket.pages.subclass.PageSwapDemo;
import java.util.TimeZone;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.markup.html.PackageResourceGuard;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestableComponent;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 ** <code>getComponentInstantiationListeners().add(new SpringComponentInjector(this));</code>
 * <p> Only Wicket {@link Component}s and {@link Behavior}s are automatically
 * injected, other classes such as {@link Session}, {@link Model}, and any other
 * POJO can be injected by calling
 * <code>Injector.get().inject(this)</code> in their constructor.
 *
 * @author dhenton
 * @version
 */
@Component(value = "wicketApplication")
public class Application extends WebApplication {

    private final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private ApplicationContext applicationContext;

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

        getMarkupSettings().setStripWicketTags(true);
        getResourceSettings().setPackageResourceGuard(new PackageResourceGuard());



        // used for selenium testing
        //http://www.wijsmullerbros.nl/content/wicket-selenium


        if (RuntimeConfigurationType.DEVELOPMENT.equals(this.getConfigurationType())) {
            getDebugSettings().setOutputComponentPath(true);
            getDebugSettings().setOutputMarkupContainerClassName(true);
        }





        IComponentInstantiationListener spListener =
                new SpringComponentInjector(this, applicationContext, true);
        this.getComponentInstantiationListeners().add(spListener);

        mountPages();

        // this is for the generated image in demo in ImageRefPage.java
        mountResource("/images/${name}", new ImageResourceReference());
        // this cleans up the url http://localhost:9090/wicket-sandbox/imagesPage?0
        // will go to the ImageRefPage
        mountPage("imagesPage", ImageRefPage.class);
        ////////////////////
//mountBookmarkablePage(page.getSimpleName(), page);
        // Register the authorization strategy
        getSecuritySettings().setAuthorizationStrategy(new IAuthorizationStrategy() {
            @Override
            public boolean isActionAuthorized(org.apache.wicket.Component component, Action action) {
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


    }

    @Override
    public Session newSession(Request request, Response response) {
        SandboxSession session = new SandboxSession(request);
        WebClientInfo info = new WebClientInfo(RequestCycle.get());
        info.getProperties().setTimeZone(TimeZone.getDefault());
        session.setClientInfo(info);
        return session;
    }

    private void mountPages() {

        Class pageArray[] = {
            HomePage.class, UserPage.class, ExploreFormPage.class, DataFilteringPage.class,
            CompoundUserPage.class, LightboxPage.class, MaintainRestaurantsTwo.class,
            ApplicationsUsers.class, SimpleEventPage.class, OnHoverPage.class,NestedFormPage.class,
            SimpleListViewRepeater.class, MaintainApplications.class,PageSwapDemo.class,
            AjaxFormPage.class, BehaviorsPage.class, DataPaging.class,AjaxIndicatorPage.class,
            FormInputWithList.class, ModalInputPage.class, SignIn.class, SignOutPage.class,
            ComplexFormPage.class,    FormListView.class

        };

        for (Class page : pageArray) {
            this.mountPage(page.getSimpleName(), page);

        }
    }
}
