package io.ecom.practice.Product.service.Imp;

import io.ecom.practice.Product.dao.ProductMapper;
import io.ecom.practice.Product.dto.ProductDetailDto;
import io.ecom.practice.Product.service.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCrudImp implements ProductCrudService {

    @Autowired
    ProductMapper mapper;

    @Override
    public int addProduct(ProductDetailDto productDetailDto, String id) {
        productDetailDto.setCreatedAt(Timestamp.from(Instant.now()));
        productDetailDto.setUpdatedAt(Timestamp.from(Instant.now()));
        mapper.addProduct(productDetailDto,id);
        return 1;
    }

    @Override
    public int addProducts(List<ProductDetailDto> products, String id) {
        List<ProductDetailDto> p = products.stream().peek(x-> {
            x.setCreatedAt(Timestamp.from(Instant.now()));
            x.setUpdatedAt(Timestamp.from(Instant.now()));
        }).collect(Collectors.toList());
        mapper.addProducts(p,id);
        return p.size();
    }


}
