package com.dhenton9000.factorydemo;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RandomFactory {
	private static Logger log = LogManager.getLogger(RandomClass.class);
	private static long myseed = 0L;
	private RandomFactory() {
	}

	/**
	 * constructor-arg in spring will pass parameters to this 
	 * factory method
	 * @param seed
	 * @return
	 */
	public static RandomClass createMyClass(long seed) {
		log.debug("a "+seed);
		Random r = new Random(myseed);
		RandomClass myClass = new RandomClass(r);
		return myClass;
	}
}
