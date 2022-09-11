package io.ecom.practice.Product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {
    @JsonIgnore
    private int productId;
    @NotNull(message = "Please Enter Product Name")
    @NotEmpty
    private String productName;
    @NotNull(message = "Please Enter Product Price")
    private double productPrice;
    private String productImg;
    @NotNull(message = "Please Enter Category")
    @NotEmpty
    private String category;
    @NotNull(message = "Please Enter Sub-Category")
    @NotEmpty
    private String subCategory;
    @JsonIgnore
    private Timestamp createdAt;
    @JsonIgnore
    private Timestamp updatedAt;

}
