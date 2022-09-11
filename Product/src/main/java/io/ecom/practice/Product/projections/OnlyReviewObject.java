package io.ecom.practice.Product.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlyReviewObject {
    private List<OnlyReview> reviewDtos;
}
