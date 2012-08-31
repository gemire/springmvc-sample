/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

import com.dhenton9000.guicesample.parties.AffliationGenerator;
import com.dhenton9000.guicesample.guice.modules.PrimitiveModule;
import com.dhenton9000.guicesample.guice.modules.SimpleModule;
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
public class TestSamples {

    private static final Logger log = LoggerFactory.getLogger(TestSamples.class);

    @Test
    public void testLogging() {
        log.debug("get a job debug");
        log.info("get another job info");
        String info = "I paid %d dollars with cash.";
        StringBuilder sb = new StringBuilder();

        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb);
        assertEquals("I paid 10 dollars with cash.", formatter.format(info, 10).toString());

    }

    
    /**
     * This method shows how Implemented by (@see PaymentMethod interface) can
     * be automatically injected into SimpleAnnotatedOrder
     */
    @Test
    public void testAnnotationBinding() {
        Injector injector = Guice.createInjector();
        //calling the getInstance
        //read the @Inject on SimpleAnnotatedOrder
        //Check the interface, see that it has an ImplementedBy
        SimpleAnnotatedOrder order = injector.getInstance(SimpleAnnotatedOrder.class);
        order.setOrderNum("A123");
        order.setAmount(5);
        String expected = "For order number A123, I paid 5 dollars with CreditCard";
        assertEquals(expected, order.reportOrderPayment());


    }
    
    /*
     * In the SimpleAnnotatedOrder override the binding via a Module, if you
     * didn't do this you'd get the behavior above
     */
    @Test
    public void testUsingBinder()
    {
        SimpleModule module = new SimpleModule();
        Injector injector = Guice.createInjector(module);
        SimpleAnnotatedOrder order = injector.getInstance(SimpleAnnotatedOrder.class);
        order.setOrderNum("A123");
        order.setAmount(5);
        String expected = "For order number A123, I paid 5 dollars with Cash";
        assertEquals(expected, order.reportOrderPayment());
        
        
    }
    
    
    @Test
    public void testPrimativeInjection()
    {
        
        PrimitiveModule module = new PrimitiveModule();
        Injector injector = Guice.createInjector(module);
        PrimitiveItem item = injector.getInstance(PrimitiveItem.class);
        assertEquals("Bozo, Hello moron!",item.getMessage());
        
    }
    
    
    @Test
    public void testUsingProvider()
    {
        SimpleModule module = new SimpleModule();
        Injector injector = Guice.createInjector(module);
       
        AffliationGenerator gen = injector.getInstance(AffliationGenerator.class); 
        
        assertEquals(2,gen.get().size());
        assertEquals("Bolshevek",gen.get().get(0));
        
    }
    
}
