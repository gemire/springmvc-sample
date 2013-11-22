package com.dhenton9000.spring.mvc.jdo.dao;

import com.dhenton9000.spring.mvc.jdo.entities.Review;

public interface ReviewDao {
	
	public static final String REVIEW_ENTITY_NAME = "Review";
	void deleteReview(Long reviewId,Long parentId);
	Review getReview(Long reviewid,Long parentId);
}
