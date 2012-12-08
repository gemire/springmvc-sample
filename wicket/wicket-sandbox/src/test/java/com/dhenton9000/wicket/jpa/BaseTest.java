/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class BaseTest {

    private static Injector injector = null;
    public static final String JPA_MODULE_NAME = "WicketJPA_PU";

    Injector getInjector() {
        assertNotNull(injector);
        return injector;
    }

    @BeforeClass
    public static void beforeClass() {
        injector = Guice.createInjector(
                new JpaPersistModule(JPA_MODULE_NAME));
        injector.getInstance(JPAServiceStarter.class);
        
    }
}
