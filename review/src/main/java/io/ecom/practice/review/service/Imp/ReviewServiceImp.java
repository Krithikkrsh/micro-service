package io.ecom.practice.review.service.Imp;

import io.ecom.practice.review.ReviewApplication;
import io.ecom.practice.review.dao.ReviewMapper;
import io.ecom.practice.review.dto.ReviewDto;
import io.ecom.practice.review.projections.ProductResponse;
import io.ecom.practice.review.projections.ReviewObject;
import io.ecom.practice.review.projections.ReviewResponse;
import io.ecom.practice.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder builder;

    @Autowired
    ReviewMapper mapper;

    public List<ReviewResponse> getProductReviews(){
        List<ReviewDto> reviews = Arrays.asList(
                new ReviewDto(1,1,1,"Really good product",4),
                new ReviewDto(2,2,2,"Really good product",5)
        );
        return List.of(
                new ReviewResponse("krithik", "really good", 5)
        );
    }

    @Override
    public ReviewObject getReviewByProduct(int id) {
        ReviewObject r = new ReviewObject();
        r.setReviewResponses(mapper.getReviewForProduct(id));
        return r;
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        mapper.getAllReviews().stream().forEach(System.out::println);
        return mapper.getAllReviews();
    }
}
