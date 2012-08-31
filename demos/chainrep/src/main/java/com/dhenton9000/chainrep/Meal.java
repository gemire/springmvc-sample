package com.dhenton9000.chainrep;

import java.util.ArrayList;

import com.dhenton9000.chainrep.testers.MealTester;

/**
 * interface that describes a meal for evaluation
 * 
 * @author Don
 * 
 */
public interface Meal {

	public MealTester.HealthRating getHealthlyRating();
	public void setHealthlyRating(MealTester.HealthRating healthlyRating);
	public ArrayList<String> getMealComponents();

}
