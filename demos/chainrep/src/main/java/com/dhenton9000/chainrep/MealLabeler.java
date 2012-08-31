package com.dhenton9000.chainrep;

import com.dhenton9000.chainrep.testers.MealTester;
import java.util.ArrayList;

/**
 * This is the interface for the meal MealLabeler. It only has one function
 * which is to get the name of the labeler for doc
 * @author dhenton
 */
public interface MealLabeler {

	public String getLabelerName();
        public ArrayList<MealTester> getMealTesters();
        public void setMealTesters(ArrayList<MealTester> mealTesters) ;
        public void labelMeal(Meal m);
        
        
        
}
