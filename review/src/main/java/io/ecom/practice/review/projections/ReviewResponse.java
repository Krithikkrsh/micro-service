package io.ecom.practice.review.projections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewResponse {
    private String name;
    private String desc;
    private int rating;
}
