package io.ecom.practice.Product.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProjections {
    private String productName;
    private int productQuantity;
    private double productPrice;
    private int noOfOrders;
}
