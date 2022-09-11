package io.ecom.practice.User.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Serializer;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto{
    @NotNull
    private int productId;
    @NotNull
    private String userId;
    private int size;
    @NotNull
    private int quantity;
    private double totalPrice;
    private Timestamp createdAt = Timestamp.from(Instant.now());
}
