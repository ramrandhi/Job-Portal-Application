package com.learn.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Review;
import com.learn.service.ReviewService;

@RestController
@RequestMapping(value = "/company/{companyId}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable("companyId") Long companyId) {
		List<Review> reviews = reviewService.findAllReviews(companyId);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable("companyId") Long companyId,
			@PathVariable("reviewId") Long reviewId) {
		Review review = reviewService.findReviewById(companyId, reviewId);
		if (review != null)
			return new ResponseEntity<>(review, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/reviews")
	public ResponseEntity<String> saveReview(@PathVariable("companyId") Long companyId, @RequestBody Review review) {
		Boolean bool = reviewService.save(companyId, review);
		if (bool)
			return new ResponseEntity<>("Review saved Successfully", HttpStatus.OK);
		return new ResponseEntity<>("Review not Saved", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable("companyId") Long companyId,
			@PathVariable("reviewId") Long reviewId, @RequestBody Review updateReview) {
		Boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, updateReview);
		if (isReviewUpdated)
			return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
		return new ResponseEntity<>("unable to update review", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable("companyId") Long companyId,
			@PathVariable("reviewId") Long reviewId) {
		Boolean isReviewDeleted = reviewService.deleteReviewById(companyId, reviewId);
		if (isReviewDeleted)
			return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Unable to delete Review", HttpStatus.NOT_FOUND);
	}

}
