package io.ecom.practice.Product.dao;

import io.ecom.practice.Product.dto.ProductDetailDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Insert("insert into products(product_name,product_price,product_img,product_dealer,created_at,updated_at)" +
            "values (#{dto.productName},#{dto.productPrice},#{dto.productImg},#{id},#{dto.createdAt},#{dto.updatedAt})")
    void addProduct(ProductDetailDto dto,String id);


    @Insert({
            "<script>",
            "Insert into products(product_name,product_price,product_img,product_dealer,created_at,updated_at)" +
                    "values" +
                    "<foreach item='product' collection='productsList' open=' ' separator=',' close='' >" +
                    "( " +
                    "#{product.productName}," ,
                    "#{product.productPrice}," ,
                    "#{product.productImg}," ,
                    "#{id}," ,
                    "#{product.createdAt}," ,
                    "#{product.updatedAt}" +") " +
                    "</foreach>",
            "</script>"
    })
    void addProducts(@Param("productsList")List<ProductDetailDto> products,String id);

    @Select("select product_dealer from products where product_id=#{id}")
    String  getDealerId(int id);

    @Select("select product_price from products where product_id=#{id}")
    int getPrice(int id);
}
