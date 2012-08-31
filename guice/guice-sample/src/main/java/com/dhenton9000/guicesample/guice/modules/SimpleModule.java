/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.guice.modules;

import com.dhenton9000.guicesample.PayWithCash;
import com.dhenton9000.guicesample.PaymentMethod;
import com.dhenton9000.guicesample.parties.AffliationGenerator;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import java.util.List;
import static com.google.inject.name.Names.*;

/**
 *
 * @author dhenton
 */
public class SimpleModule extends AbstractModule {

    @Override
    protected void configure() {
        //this shows that you can override a @ImplementedBy
        this.bind(PaymentMethod.class).to(PayWithCash.class);
        // this is equivalent to passing a constant to the AffliationGenerator
        // class which is a factory. This sets what kind of factory it is
        this.bindConstant().annotatedWith(named("listType")).to("communist");
        bind(new TypeLiteral<List<String>>() {}).toProvider(AffliationGenerator.class);

    }
}
