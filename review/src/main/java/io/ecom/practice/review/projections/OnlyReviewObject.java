package io.ecom.practice.review.projections;

import io.ecom.practice.review.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlyReviewObject {
    List<ReviewDto> reviewDtos;
}
