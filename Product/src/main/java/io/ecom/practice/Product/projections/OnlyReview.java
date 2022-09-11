package io.ecom.practice.Product.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlyReview {
    private int id;
    private int userId;
    private int productId;
    private String reviews;
    private int rating;

}
