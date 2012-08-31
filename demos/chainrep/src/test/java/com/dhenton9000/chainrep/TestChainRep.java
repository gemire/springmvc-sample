package com.dhenton9000.chainrep;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dhenton9000.chainrep.testers.MealTester;
/**
 * This class tests the meal rating system. A meal is composed of a list of 
 * meal components which is just an arrayList of Strings. 
 * "banana", "fudge", "bozo"
 * 
 * The labeler searches the list of strings in the meal and assigns a health
 * rating to the meal. The rating is based on the last string that it finds that
 * matches. The labeler contains an array list of testers that do the testing
 * 
 * The strings that it searches for and the health ratings that are assigned 
 * when a match is made are determined by the array of meal testers. The labeler
 * spins thru the collection and  breaks out on a hit
 * the last
 * 
 * 
 * @author dhenton
 */
public class TestChainRep {
	private static Logger log = LogManager.getLogger(TestChainRep.class);
	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"chainrep-spring.xml");
	private SimpleMealLabeler labeler = (SimpleMealLabeler) ctx.getBean("mealLabeler");

	@Test
	public void testTesterItems() {
		Assert.assertEquals(3, labeler.getMealTesters().size());
	}

	@Test
	public void testLowMeal() throws Exception {
		log.debug("low");
		Meal m = (Meal) ctx.getBean("lowMeal");
		Assert.assertEquals(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		labeler.labelMeal(m);
		Assert.assertNotSame(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		Assert.assertEquals(MealTester.HealthRating.LOW, m.getHealthlyRating());

	}

	@Test
	public void testHighMeal() throws Exception {
		log.debug("high");
		Meal m = (Meal) ctx.getBean("highMeal");
		Assert.assertEquals(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		labeler.labelMeal(m);
		Assert.assertNotSame(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		Assert.assertEquals(MealTester.HealthRating.HIGH, m.getHealthlyRating());

	}

	@Test
	public void testFailMeal() throws Exception {
		log.debug("fail");
		Meal m = (Meal) ctx.getBean("failMeal");
		Assert.assertEquals(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		labeler.labelMeal(m);
		Assert.assertEquals(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());

	}

	@Test
	public void testMixedMeal() throws Exception {
		log.debug("mixed");
		Meal m = (Meal) ctx.getBean("mixedMeal");
		Assert.assertEquals(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		labeler.labelMeal(m);
		Assert.assertNotSame(MealTester.HealthRating.NOT_SET,
				m.getHealthlyRating());
		Assert.assertEquals(MealTester.HealthRating.LOW, m.getHealthlyRating());

	}

}
