package io.ecom.practice.Product.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto{
    private int id;
    private String name;
    private int price;
}
