package com.dhenton9000.guice.chainrep;

 

/**
 * The interface for the tester. It will test the meal and then modify a
 * property on the meal
 * 
 * @author Don
 * 
 */
public interface MealTester {

    public void testMeal(Meal m);

    public enum HealthRating {

        NOT_SET, LOW, MODERATE, HIGH
    }

    public void setLabeler(MealLabeler mealLabeler);
    public HealthRating getHealthRating();
    public void setHealthRating(HealthRating healthRating);
    public String getTesterName();
    public void setTesterName(String testerName);
    public String getTestItem();
    public void setTestItem(String testItem);
}
