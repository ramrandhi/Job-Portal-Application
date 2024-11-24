package com.learn.service;

import java.util.List;

import com.learn.entity.Review;

public interface ReviewService {

	List<Review> findAllReviews(Long companyId);

	Review findReviewById(Long companyId, Long reviewId);

	Boolean save(Long companyId, Review review);

	Boolean updateReview(Long companyId, Long reviewId, Review updateReview);

	Boolean deleteReviewById(Long companyId, Long reviewId);

}
