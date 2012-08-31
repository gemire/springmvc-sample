/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.guice.modules;

 
 
import com.dhenton9000.guice.chainrep.Meal;
import com.dhenton9000.guice.chainrep.MealLabeler;
import com.dhenton9000.guice.chainrep.MealTester;

import com.dhenton9000.guice.chainrep.impl.BaseMeal;
import com.dhenton9000.guice.chainrep.impl.BaseMealLabeler;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.dhenton9000.guice.chainrep.impl.BaseMealTester;
import com.dhenton9000.guicesample.meals.SampleMeals;
import com.dhenton9000.guicesample.meals.SampleMealsImpl;
import com.google.inject.multibindings.MapBinder;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dhenton
 */
public class ChainRepModule extends AbstractModule {

    @Override
    protected void configure() {
    
        
        // set up the Labeler with its collection of testers
        Multibinder<MealTester> mealTesterSetBinder  = 
                  Multibinder.newSetBinder(binder(),MealTester.class);
        BaseMealTester t = null;
        t = new BaseMealTester("banana",BaseMealTester.HealthRating.HIGH,"bananaBean");
        mealTesterSetBinder.addBinding().toInstance(t);
        t = new BaseMealTester("fudge",BaseMealTester.HealthRating.LOW,"fudgeBean");
        mealTesterSetBinder.addBinding().toInstance(t);
        t = new BaseMealTester("apple",BaseMealTester.HealthRating.HIGH,"appleBean");
        mealTesterSetBinder.addBinding().toInstance(t);
        this.bind(MealLabeler.class).to(BaseMealLabeler.class);
        
        //// set up some sample data //////////////////////////////////////
        
        MapBinder<String,Meal> sampleDataBinder = 
                MapBinder.newMapBinder(binder(), String.class, Meal.class);
        Set s = null;
        s = new HashSet();
        s.add("fred");
        s.add("bonzo");
        s.add("get a job");
        s.add("snarkville");
        sampleDataBinder.addBinding("failMeal").toInstance(new BaseMeal(s));

        s = new HashSet();
        s.add("get a job");
        s.add("fudge");
        s.add("apple");
        sampleDataBinder.addBinding("lowMeal").toInstance(new BaseMeal(s));
 
        
        s = new HashSet();
        
        s.add("fudge");
        s.add("apple");
        s.add("elmo");
        sampleDataBinder.addBinding("mixedMeal").toInstance(new BaseMeal(s));
        
        
        
        s = new HashSet();
        s.add("banana");
        s.add("banana");
        s.add("fudge");
        sampleDataBinder.addBinding("highMeal").toInstance(new BaseMeal(s));
        this.bind(SampleMeals.class).to(SampleMealsImpl.class);
                
        
    }
    
}
