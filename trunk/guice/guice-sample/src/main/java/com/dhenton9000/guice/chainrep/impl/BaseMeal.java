package com.dhenton9000.guice.chainrep.impl;

import com.dhenton9000.guice.chainrep.Meal;
import com.dhenton9000.guice.chainrep.MealTester;
import java.util.HashSet;
import java.util.Set;

 

/*
 * An implementation of the Meal interface. A meal contains components
 * which are string food names. These are injected by spring. The health
 * rating is set by the meal labeler {@link MealLabeler}
 */

public class BaseMeal implements Meal {

	private MealTester.HealthRating healthlyRating = MealTester.HealthRating.NOT_SET;
	private Set<String> mealComponents = new HashSet<String>();

	public BaseMeal(Set<String> t) {
		mealComponents = t;
	}

        public BaseMeal()
        {
            
        }
	public MealTester.HealthRating getHealthlyRating() {
		return healthlyRating;
	}

	public void setHealthlyRating(MealTester.HealthRating healthlyRating) {
		this.healthlyRating = healthlyRating;
	}

	public Set<String> getMealComponents() {
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
