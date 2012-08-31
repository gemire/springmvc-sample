package com.dhenton9000.guice.chainrep;

 
import java.util.ArrayList;
import java.util.Set;

/**
 * This is the interface for the meal MealLabeler. It only has one function
 * which is to get the name of the labeler for doc
 * @author dhenton
 */
public interface MealLabeler {

	public String getLabelerName();
        public Set<MealTester> getMealTesters();
        public void setMealTesters(Set<MealTester> mealTesters) ;
        public void labelMeal(Meal m);
        
        
        
}
