package io.ecom.practice.Product.service.Imp;

import io.ecom.practice.Product.dao.ProductRepo;
import io.ecom.practice.Product.dto.ProductDto;
import io.ecom.practice.Product.projections.*;
import io.ecom.practice.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    WebClient.Builder builder;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepo repo;

    @Override
    public ProductResponse getProductById(int id) throws Exception {
        ReviewObject reviewObject = builder.build().
                get()
                .uri("http://REVIEW-SERVICE/review/getReviewByProduct?id="+id)
                .retrieve()
                .bodyToMono(ReviewObject.class)
                .block();
        Optional<ProductDto> product = Optional.ofNullable(repo.getProductById(id).orElseThrow(Exception::new));
        var p = product.get();
        assert reviewObject != null;
        return new ProductResponse(p.getName(), p.getPrice(), reviewObject.getReviewResponses());

    }

    @Override
    public List<ProductRated> getAllProducts() {
        OnlyReviewObject object = restTemplate.getForObject("http://REVIEW-SERVICE/review/getAllReviews",OnlyReviewObject.class);
        assert object != null;
        List<ProductDto> p = repo.getAllProducts();
        return p.stream().map(productDto -> {
            double count = (double) object
                    .getReviewDtos().stream()
                    .filter(onlyReview -> onlyReview.getProductId() == productDto.getId())
                    .mapToDouble(OnlyReview::getRating)
                    .count();
            double sum = (double) object
                    .getReviewDtos().stream()
                    .filter(onlyReview -> onlyReview.getProductId() == productDto.getId())
                    .mapToDouble(OnlyReview::getRating)
                    .sum();
            ProductRated s = new ProductRated();
            s.setName(productDto.getName());
            s.setPrice(productDto.getPrice());
            s.setAvg_rating(String.format("%.1f",sum/count));
            return s;
        }).collect(Collectors.toList());
    }
}
