package com.dhenton9000.factorydemo;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RandomClass {
	private static Logger log = LogManager.getLogger(RandomTester.class);
	private String message = null;
	private Random rr = null;
	
	public RandomClass() {
		rr = new Random();
	}

	
	public RandomClass(Random r) {
		 rr = r;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String applyRandom() {

		return (getMessage()+" " + rr.nextInt(101));

	}

}
