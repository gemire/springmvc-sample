package com.dhenton9000.chainrep.testers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.dhenton9000.chainrep.MealLabeler;
import com.dhenton9000.chainrep.Meal;

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
	private static Logger log = LogManager.getLogger(BaseMealTester.class);
	private String testerName = null;
	private MealLabeler labeler = null;

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

}
