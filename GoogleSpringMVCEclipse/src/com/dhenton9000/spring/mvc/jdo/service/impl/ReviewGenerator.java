package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.Review;

public class ReviewGenerator {

	private static Logger logger = LogManager.getLogger(ReviewGenerator.class);
	private static final Random random = new Random();
	private static final String[] sampleReviews = {

	"A real gas", "Mediocre soups and disgusting desserts",
			"Impeccable service!", "Consider suicide first",
			"Get a job, instead of eating here!",
			"Can you say 'gastric bypass'?", "A root canal would be better",
			"Too noisy and the food tasted funny"

	};

	public void generateReviews(Restaurant r) {
		int n = getNumberOfReviews();

		if (n == 0) {

			return;
		}

		for (int i = 0; i < n; i++) {
			r.addReview(getStarRating(), getRandomReview());
		}

	}

	private String getRandomReview() {
		int revNum = random.nextInt(sampleReviews.length + 1 - 0) + 0;
		if (revNum < sampleReviews.length - 1) {
			return sampleReviews[revNum];
		} else {
			return "You don't know what you are missing";
		}
	}

	private int getNumberOfReviews() {
		int revCount = random.nextInt(5 - 0) + 0;
		if (revCount == 0)
			revCount = 1;
		
		return revCount;
	}

	private int getStarRating() {
		return random.nextInt(9 - 1) + 1;

	}
}
