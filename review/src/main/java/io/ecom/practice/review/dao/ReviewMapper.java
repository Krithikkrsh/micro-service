package io.ecom.practice.review.dao;

import io.ecom.practice.review.dto.ReviewDto;
import io.ecom.practice.review.projections.ReviewResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Select("select * from review")
    List<ReviewDto> getAllReviews();

    @Select("select u.name,r.reviews,r.rating from (users u join review r on u.id=r.user_id) where r.product_id = #{id}")
    List<ReviewResponse> getReviewForProduct(int id);

}
