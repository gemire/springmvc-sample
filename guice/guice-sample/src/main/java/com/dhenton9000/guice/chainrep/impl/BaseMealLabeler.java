package com.dhenton9000.guice.chainrep.impl;

import com.dhenton9000.guice.chainrep.Meal;
import com.dhenton9000.guice.chainrep.MealLabeler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dhenton9000.guice.chainrep.MealTester;
import com.dhenton9000.guice.chainrep.MealTester.HealthRating;
import com.google.inject.Inject;
import java.util.Set;

/**
 * This class is the chain of responsibility processor It will take a meal,
 * characterize it based on contents It short circuits on the first item it
 * finds. It uses a collection of
 * {@link com.dhenton9000.guice.chainrep.MealTesters}
 * 
 * @author Don
 * 
 */
public class BaseMealLabeler implements MealLabeler {

    private static Logger log = LoggerFactory.getLogger(BaseMealLabeler.class);
    @Inject
    private Set<MealTester> mealTesters = null;
    
    
    public Set<MealTester> getMealTesters() {
        return mealTesters;
    }

    public void setMealTesters(Set<MealTester> mealTesters) {
        // the individual testers now have a pointer to
        // the container if needed
        for (MealTester t : mealTesters) {
            t.setLabeler(this);
        }

        this.mealTesters = mealTesters;
    }
   

    public void labelMeal(Meal m) {
        for (MealTester mt : mealTesters) {
            mt.testMeal(m);
            if (m.getHealthlyRating().compareTo(HealthRating.NOT_SET) != 0) {
                log.debug("break out!");
                return;
            }
        }
    }

    public String getLabelerName() {

        return "basic labeler";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseMealLabeler other = (BaseMealLabeler) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "MealLabeler{" + "mealTesters=" + mealTesters + '}';
    }
}
