package com.dhenton9000.guice.chainrep.impl;

import com.dhenton9000.guice.chainrep.Meal;
import com.dhenton9000.guice.chainrep.MealLabeler;
import com.dhenton9000.guice.chainrep.MealTester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This base class will assign a rating to a meal if it detects the string 
 * provided in testItem in the arrayList of items in the meal
 * It short circuits
 * 
 * @author Don
 * 
 */
public class BaseMealTester implements MealTester {
	private String testItem = null;
	private HealthRating healthRating = null;
	private static Logger log = LoggerFactory.getLogger(BaseMealTester.class);
	private String testerName = null;
	private MealLabeler labeler = null;

    public BaseMealTester(String tItem, HealthRating hr, String tName) {
         testItem = tItem;
         healthRating = hr;
         testerName = tName;
    }

     public BaseMealTester() {
        
    }
    
	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getTestItem() {
		if (testItem == null)
			return "";
		else
			return testItem.toUpperCase().trim();
	}

	public void setTestItem(String testItem) {
		this.testItem = testItem;
	}

	public HealthRating getHealthRating() {
		return healthRating;
	}

	public void setHealthRating(HealthRating healthRating) {
		this.healthRating = healthRating;
	}

	public void testMeal(Meal m) {
		for (String t : m.getMealComponents()) {
			String mC = t.toUpperCase().trim();
			log.debug(getTesterName() + "--comparing component " + mC
					+ " to searchword " + getTestItem());
			if (mC.equals(getTestItem())) {
				m.setHealthlyRating(getHealthRating());
				break;
			}
		}

	}

	public void setLabeler(MealLabeler mealLabeler) {
		labeler = mealLabeler;
		log.debug("labeler is " + labeler.getLabelerName() + " for "
				+ testerName);

	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseMealTester other = (BaseMealTester) obj;
        if ((this.testItem == null) ? (other.testItem != null) : !this.testItem.equals(other.testItem)) {
            return false;
        }
        if (this.healthRating != other.healthRating) {
            return false;
        }
        if ((this.testerName == null) ? (other.testerName != null) : !this.testerName.equals(other.testerName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.testItem != null ? this.testItem.hashCode() : 0);
        hash = 71 * hash + (this.healthRating != null ? this.healthRating.hashCode() : 0);
        hash = 71 * hash + (this.testerName != null ? this.testerName.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BaseMealTester{" + "testItem=" + testItem + ", healthRating=" + healthRating + '}';
    }

}
