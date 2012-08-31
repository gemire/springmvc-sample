package com.dhenton9000.factorydemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomTester {
	private static Logger log = LogManager.getLogger(RandomClass.class);
	private static ClassPathXmlApplicationContext ctx = null;

	@BeforeClass
	public static void setup() {
		ctx = new ClassPathXmlApplicationContext("spring-random.xml");
	}

	@Test
	public void testRandom() {

		log.debug("starting test");
		RandomClass r = (RandomClass) ctx.getBean("randomBean");
		Assert.assertEquals("fred", r.applyRandom());
		log.debug("finishing downloads");
	}

}
