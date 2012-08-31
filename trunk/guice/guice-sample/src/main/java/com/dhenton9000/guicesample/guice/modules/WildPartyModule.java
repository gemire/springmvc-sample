/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.guice.modules;

import com.dhenton9000.guicesample.people.SimplePerson;
import com.dhenton9000.guicesample.people.PartyPeople;
import com.dhenton9000.guicesample.people.MalePerson;
import com.dhenton9000.guicesample.annotations.PropertyItem;
import com.dhenton9000.guicesample.providers.PropertyProvider;
import com.dhenton9000.guicesample.people.Person;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import java.util.HashSet;
import java.util.Set;
import static com.google.inject.name.Names.*;

/**
 *
 * @author Don
 */
public class WildPartyModule extends AbstractModule {
//http://google-guice.googlecode.com/git-history/snapshot20080611/
//extensions/multibindings/test/com/google/inject/multibindings/MultibinderTest.java

    @Override
    protected void configure() {
        Person p = null;
        p = new MalePerson("John", 55, true);
        Multibinder<Person> boringBinder =
                Multibinder.newSetBinder(binder(), Person.class, named("boring"));
        boringBinder.addBinding().toInstance(p);

        Multibinder<Person> coolBinder =
                Multibinder.newSetBinder(binder(), Person.class, named("cool"));
        p = new SimplePerson("Jane", 25, false);
        coolBinder.addBinding().toInstance(p);


        bind(PartyPeople.class);
    
    }

}
