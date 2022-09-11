package io.ecom.practice.Product.dao;

import io.ecom.practice.Product.dto.AddressDto;
import io.ecom.practice.Product.dto.ProductDealer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface DealerMapper {

    @Insert("Insert into dealer(dealer_id,dealer_name,dealer_phone,created_at,updated_at,dealer_password) " +
            "values (#{dealerID},#{dealerName},#{dealerPhoneNumber},#{createdAt},#{updatedAt},#{dealerPassword})")
    void addDealer(ProductDealer dealer);

    @Insert("insert into address(shop_no,street_name,road_name,land_mark,city,district,state,country,pin_code,dealer_id,created_at,updated_at)" +
            "values (#{dto.shopNo},#{dto.streetName},#{dto.roadName},#{dto.landMark},#{dto.city},#{dto.district},#{dto.state},#{dto.country},#{dto.pinCode},#{id},#{dto.createdAt},#{dto.updatedAt})")
    void addAddress(AddressDto dto, String id);

    @Select("select * from dealer where dealer_id=#{id}")
    @Results(value = {
            @Result(property = "dealerID", column = "dealer_id"),
            @Result(property = "dealerName", column = "dealer_name"),
            @Result(property = "dealerPhoneNumber", column = "dealer_phone"),
            @Result(property = "dealerAddress", javaType = Optional.class,
                    column = "dealer_id", many = @Many(select = "getAddress"))
    })
    Optional<ProductDealer> getDealerById(String id);

    @Select("select * from dealer")
    @Results(value = {
            @Result(property = "dealerID", column = "dealer_id"),
            @Result(property = "dealerName", column = "dealer_name"),
            @Result(property = "dealerPhoneNumber", column = "dealer_phone"),
            @Result(property = "dealerAddress", javaType = Optional.class,
                    column = "dealer_id", many = @Many(select = "getAddress"))
    })
    List<ProductDealer> getDealers();

    @Select("select * from address where dealer_id=#{id}")
    Optional<AddressDto> getAddress(String id);


}
