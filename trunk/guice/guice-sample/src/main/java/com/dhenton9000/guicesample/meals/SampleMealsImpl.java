/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.meals;

import com.dhenton9000.guice.chainrep.Meal;
import com.dhenton9000.guicesample.meals.SampleMeals;
import com.google.inject.Inject;
import java.util.Map;
 

/**
 *
 * @author dhenton
 */
public class SampleMealsImpl implements SampleMeals {
    @Inject
    private Map<String,Meal> meals = null;

    /**
     * @return the meals
     */
    @Override
    public Map<String,Meal> getMeals() {
        return meals;
    }
}
