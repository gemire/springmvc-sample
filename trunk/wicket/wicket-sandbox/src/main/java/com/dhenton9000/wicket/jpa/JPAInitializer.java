/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

/**
 *
 * @author dhenton
 */
 
    
import com.google.inject.persist.jpa.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.persist.PersistFilter;
public class JPAInitializer extends GuiceServletContextListener{
    @Override
    public Injector getInjector() {
    return Guice.createInjector(
      new  JpaPersistModule("WicketJPA_PU"  ),
      new ServletModule() {
        @Override
        protected void configureServlets() {



          filter("/*").through(PersistFilter.class);


        //  bind(BookDAO.class).to (BookDAOImpl.class);
        }
    });
    } 
}
    
 
