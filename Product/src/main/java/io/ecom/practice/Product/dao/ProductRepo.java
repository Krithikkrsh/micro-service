package io.ecom.practice.Product.dao;

import io.ecom.practice.Product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepo {

    @Select("Select * from products")
    List<ProductDto> getAllProducts();

    @Select("select * from products where product_id=#{id}")
    Optional<ProductDto> getProductById(int id);
}
