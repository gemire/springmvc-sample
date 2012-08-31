/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guice.chainrep;

import com.dhenton9000.guicesample.meals.SampleMeals;
import com.dhenton9000.guicesample.guice.modules.ChainRepModule;
import java.util.Map;
import java.util.Set;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author dhenton
 */
public class TestChainRep {

    private static Injector injector = null;
    private static Map<String, Meal> testMeals = null;
    private static MealLabeler labeler = null;
    private static Logger log = LoggerFactory.getLogger(TestChainRep.class);

    @BeforeClass
    public static void beforeClass() {
        injector = Guice.createInjector(new ChainRepModule());
        testMeals = injector.getInstance(SampleMeals.class).getMeals();
        labeler = injector.getInstance(MealLabeler.class);
    }

    @Test
    public void doesLabelerHaveTesters() {
        labeler = injector.getInstance(MealLabeler.class);
        assertNotNull(labeler);
    }

    @Test
    public void doesLabelerHasCorrectCountOfTesters() {
        labeler = injector.getInstance(MealLabeler.class);
        assertEquals(3, labeler.getMealTesters().size());

        Set<MealTester> sT = labeler.getMealTesters();
        boolean gotIt = true;
        for (MealTester t : sT) {

            String tItem = t.getTestItem();
            if ("banana".toUpperCase().equals(tItem)) {
                gotIt = true;
                break;
            }
        }
        assertTrue(gotIt);

    }

    @Test
    public void checkIfTestMealsAreOk() {
        Meal mm = testMeals.get("failMeal");
        assertNotNull(mm);
        assertEquals(4, mm.getMealComponents().size());
    }

    @Test
    public void testLowMeal() throws Exception {
        log.debug("low");
        Meal m = testMeals.get("lowMeal");
        assertEquals(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        labeler.labelMeal(m);
        assertNotSame(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        assertEquals(MealTester.HealthRating.LOW, m.getHealthlyRating());

    }

    @Test
    public void testHighMeal() throws Exception {
        log.debug("high");
        Meal m = (Meal) testMeals.get("highMeal");
        assertEquals(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        labeler.labelMeal(m);
        assertNotSame(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        assertEquals(MealTester.HealthRating.HIGH, m.getHealthlyRating());

    }

    @Test
    public void testFailMeal() throws Exception {
        log.debug("fail");
        Meal m = (Meal) testMeals.get("failMeal");
        assertEquals(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        labeler.labelMeal(m);
        assertEquals(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());

    }

    @Test
    public void testMixedMeal() throws Exception {
        log.debug("mixed");
        Meal m = testMeals.get("mixedMeal");
        assertEquals(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        labeler.labelMeal(m);
        assertNotSame(MealTester.HealthRating.NOT_SET,
                m.getHealthlyRating());
        assertEquals(MealTester.HealthRating.LOW, m.getHealthlyRating());

    }
}
