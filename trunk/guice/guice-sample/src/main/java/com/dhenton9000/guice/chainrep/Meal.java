package com.dhenton9000.guice.chainrep;

import java.util.ArrayList;
import java.util.Set;

 

/**
 * interface that describes a meal for evaluation
 * 
 * @author Don
 * 
 */
public interface Meal {

	public MealTester.HealthRating getHealthlyRating();
	public void setHealthlyRating(MealTester.HealthRating healthlyRating);
	public Set<String> getMealComponents();

}
