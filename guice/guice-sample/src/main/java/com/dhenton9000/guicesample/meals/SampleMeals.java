/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.meals;

import com.dhenton9000.guice.chainrep.Meal;
import java.util.Map;
 

/**
 *
 * @author dhenton
 */
public interface SampleMeals {

    /**
     * @return the meals
     */
    Map<String,Meal> getMeals();
    
}
