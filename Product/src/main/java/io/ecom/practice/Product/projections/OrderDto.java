package io.ecom.practice.Product.projections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int productId;
    private String userId;
    private int size;
    private int quantity;
    private double totalPrice;
    private Timestamp createdAt = Timestamp.from(Instant.now());
}
