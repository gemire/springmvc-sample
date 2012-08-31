/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.providers;

import com.dhenton9000.guicesample.guice.modules.ProvidesAnnotationModule;
import com.google.inject.Inject;
import com.dhenton9000.guicesample.MailService;
import org.junit.Test;
import com.dhenton9000.guicesample.annotations.PropertyItem;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class ProviderTest {

    

    @BeforeClass
    public static void before() {
        
    }
    
    
    
    @Test
      public void testAnnotationInjection()
    {
       
        Injector
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(Boolean.class).annotatedWith(new PropertyItem("BOOLEAN")).toProvider(new PropertyProvider<Boolean>(Boolean.TRUE));
                bind(Integer.class).annotatedWith(new PropertyItem("INTEGER")).toProvider(new PropertyProvider<Integer>(4));
                bind(String.class).annotatedWith(new  PropertyItem("STRING")).toProvider(new PropertyProvider<String>("fred"));
                //bind(AnnotationSample.class);
            }
        });
        
        
        
        
        AnnotationSample sample = injector.getInstance(AnnotationSample.class);
        assertEquals(4,sample.getIntegerTest());
        assertEquals("fred",sample.getTestString());
    }
    
    @Test
    public void testProvidesAnnotation()
    {
          Injector tInject = Guice.createInjector(new ProvidesAnnotationModule());
          ProvidesAnnotationSample sample =
          tInject.getInstance(ProvidesAnnotationSample.class);
          assertTrue(sample.reportService().indexOf("alpha")==0);
          
          
    }
            
    
    
    
}
