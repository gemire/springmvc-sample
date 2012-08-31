/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.inject.provider;


import com.google.inject.Binding;
import com.google.inject.Key;
import java.util.Map;
import org.junit.BeforeClass;
import com.google.inject.Injector;
import com.google.inject.Guice;
import java.util.Formatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class TestInjectClass {

    private static final Logger log = LoggerFactory.getLogger(TestInjectClass.class);
    private static Injector injector = null;

   @BeforeClass
   public static void beforeClass()
   {
        
        InjectedClassModule module = new InjectedClassModule();
        injector = Guice.createInjector(module);

   }
    
    @Test
    public void testInjectorContents()
    {
        Map<Key<?>, Binding<?>> mapItem = injector.getAllBindings();
        assertEquals(5,mapItem.size());
//        for(Key<?> k: mapItem.keySet())
//        {
//             Object t =mapItem.get(k);
//             log.debug("t "+t.getClass().getName());
//        }
        
    }
    
    @Test
    public void testInjectAClass()
    {
        InjectedClass iClass = injector.getInstance(InjectedClass.class);
        assertTrue(iClass.getMessage().toUpperCase().indexOf("GET A JOB") > -1);
        log.debug(iClass.getMessage());
        log.debug(iClass.getMessage());
        log.debug(iClass.getMessage());
    }
    
    
    
}
