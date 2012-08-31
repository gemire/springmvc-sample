package com.dhenton9000.chainrep;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.chainrep.testers.MealTester;
import com.dhenton9000.chainrep.testers.MealTester.HealthRating;

/**
 * This class is the chain of responsibility processor It will take a meal,
 * characterize it based on contents It short circuits on the first item it
 * finds. It uses a collection of
 * {@link com.dhenton9000.chainrep.testers.MealTesters}
 * 
 * @author Don
 * 
 */

public class SimpleMealLabeler implements MealLabeler {
	private static Logger log = LogManager.getLogger(SimpleMealLabeler.class);

	public ArrayList<MealTester> getMealTesters() {
		return mealTesters;
	}

	public void setMealTesters(ArrayList<MealTester> mealTesters) {
		// the individual testers now have a pointer to
		// the container if needed
		for (MealTester t : mealTesters) {
			t.setLabeler(this);
		}

		this.mealTesters = mealTesters;
	}

	private ArrayList<MealTester> mealTesters = null;

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
        final SimpleMealLabeler other = (SimpleMealLabeler) obj;
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
