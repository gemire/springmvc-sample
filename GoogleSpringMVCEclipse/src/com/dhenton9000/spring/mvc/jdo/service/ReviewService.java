package com.dhenton9000.spring.mvc.jdo.service;

import java.util.List;

import com.dhenton9000.spring.mvc.jdo.entities.Review;

public interface ReviewService {

	List<Review> getReviewsForRestaurant(Long restaurantId);
	Long addReview(Review newReview,Long parentRestaurantId);
	void deleteReview(Long reviewId);
	Long saveReview(Review newReview);
	Review getReview(Long reviewid);
}
