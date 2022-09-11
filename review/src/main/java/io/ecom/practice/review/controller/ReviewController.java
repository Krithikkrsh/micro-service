package io.ecom.practice.review.controller;

import io.ecom.practice.review.dto.ReviewDto;
import io.ecom.practice.review.projections.OnlyReviewObject;
import io.ecom.practice.review.projections.ReviewObject;
import io.ecom.practice.review.projections.ReviewResponse;
import io.ecom.practice.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/hello")
    public String hello(){
        return "Hi I Am Review Woking Fine";
    }

    @GetMapping("/getReview")
    public List<ReviewResponse> getProductReviews(){
        return reviewService.getProductReviews();
    }

    @GetMapping("/getReviewByProduct")
    public ReviewObject getReviewByProduct(@RequestParam("id") int id){

        return reviewService.getReviewByProduct(id);
    }

    @GetMapping("/getAllReviews")
    public OnlyReviewObject getAllReviews(){
        OnlyReviewObject s = new OnlyReviewObject();
        s.setReviewDtos(reviewService.getAllReviews());
        return s;
    }
}
