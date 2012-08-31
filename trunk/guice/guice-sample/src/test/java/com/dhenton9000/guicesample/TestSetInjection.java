/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;
import com.dhenton9000.guicesample.people.Person;
import com.dhenton9000.guicesample.people.PartyPeople;
import com.dhenton9000.guicesample.guice.modules.WildPartyModule;
import com.google.inject.Injector;
import com.google.inject.Guice;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;
/**
 *
 * @author Don
 */
public class TestSetInjection {
    private static final Logger log = LoggerFactory.getLogger(TestSamples.class);
    
    @Test
    public void checkSets()
    {
         Injector injector = Guice.createInjector(new WildPartyModule());
         
         PartyPeople p = injector.getInstance(PartyPeople.class);
         assertNotNull(p.getGroup1());
         Person z = p.getGroup1().iterator().next();
         assertEquals("Mr. John",z.getName());
         
    }
    
    
}
