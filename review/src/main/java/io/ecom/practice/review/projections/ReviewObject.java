package io.ecom.practice.review.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewObject {
    private List<ReviewResponse> reviewResponses;
}
