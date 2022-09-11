package io.ecom.practice.review.service;

import io.ecom.practice.review.dto.ReviewDto;
import io.ecom.practice.review.projections.ReviewObject;
import io.ecom.practice.review.projections.ReviewResponse;

import java.util.List;

public interface ReviewService {

    List<ReviewResponse> getProductReviews();

    ReviewObject getReviewByProduct(int id);

    List<ReviewDto> getAllReviews();
}
