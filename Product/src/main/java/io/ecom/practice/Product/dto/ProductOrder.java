package io.ecom.practice.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    private int productId;
    private String dealerId;
    private int quantity;
    private int size;
    private boolean isDelivered;
    private Timestamp orderedAt;
    private double totalAmt;
}
