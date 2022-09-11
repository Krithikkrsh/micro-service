package io.ecom.practice.User.dao;

import io.ecom.practice.User.dto.OrderDto;
import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {

    @Insert("insert into orders (product_id,user_id,created_at,quantity,size)" +
            "values (#{productId},#{userId},#{createdAt},#{quantity},#{size})")
    void addOrder(OrderDto dto);
}
