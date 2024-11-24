package com.learn.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.entity.Company;
import com.learn.entity.Review;
import com.learn.repository.ReviewRepository;
import com.learn.service.CompanyService;
import com.learn.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> findAllReviews(Long companyId) {
		return reviewRepository.findByCompanyId(companyId);
	}

	@Override
	public Review findReviewById(Long companyId, Long reviewId) {
		Company company = companyService.getCompanyById(companyId);
		return company.getReviews().stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public Boolean save(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if (company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
		Company company = companyService.getCompanyById(companyId);
		Review existingReview = company.getReviews().stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
		if(existingReview != null) {
			existingReview.setCompany(company);
			existingReview.setId(reviewId);
			reviewRepository.save(updateReview);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteReviewById(Long companyId, Long reviewId) {
		if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(companyId, company);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

}
