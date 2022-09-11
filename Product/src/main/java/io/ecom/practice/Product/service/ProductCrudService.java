package io.ecom.practice.Product.service;

import io.ecom.practice.Product.dto.ProductDetailDto;

import java.util.List;

public interface ProductCrudService {

    int addProduct(ProductDetailDto productDetailDto,String id);

    int addProducts(List<ProductDetailDto> products,String id);
}
