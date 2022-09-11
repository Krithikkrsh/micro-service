package io.ecom.practice.Product.service;

import io.ecom.practice.Product.projections.ProductRated;
import io.ecom.practice.Product.projections.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(int id) throws Exception;

    List<ProductRated> getAllProducts();
}
