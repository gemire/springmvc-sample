package com.dhenton9000.chainrep;

import java.util.ArrayList;

import com.dhenton9000.chainrep.testers.MealTester;

/*
 * An implementation of the Meal interface. A meal contains components
 * which are string food names. These are injected by spring. The health
 * rating is set by the meal labeler {@link MealLabeler}
 */

public class BaseMeal implements Meal {

	private MealTester.HealthRating healthlyRating = MealTester.HealthRating.NOT_SET;
	private ArrayList<String> mealComponents = new ArrayList<String>();

	BaseMeal(ArrayList<String> t) {
		mealComponents = t;
	}

	public MealTester.HealthRating getHealthlyRating() {
		return healthlyRating;
	}

	public void setHealthlyRating(MealTester.HealthRating healthlyRating) {
		this.healthlyRating = healthlyRating;
	}

	public ArrayList<String> getMealComponents() {
		return mealComponents;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseMeal other = (BaseMeal) obj;
        if (this.healthlyRating != other.healthlyRating) {
            return false;
        }
        if (this.mealComponents != other.mealComponents && (this.mealComponents == null || !this.mealComponents.equals(other.mealComponents))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.healthlyRating != null ? this.healthlyRating.hashCode() : 0);
        hash = 89 * hash + (this.mealComponents != null ? this.mealComponents.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BaseMeal{" + "healthlyRating=" + healthlyRating + ", mealComponents=" + mealComponents + '}';
    }

        
        
}
