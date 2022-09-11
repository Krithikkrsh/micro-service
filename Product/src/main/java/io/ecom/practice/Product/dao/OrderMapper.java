package io.ecom.practice.Product.dao;

import io.ecom.practice.Product.dto.ProductOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Insert("insert into porder (product_id,dealer_id,ordered_at,quantity,size,is_delivered,total_amt)" +
            "values (#{productId},#{dealerId},#{orderedAt},#{quantity},#{size},#{isDelivered},#{totalAmt})")
    void addOrder(ProductOrder order);

    @Select("select * from porder where dealer_id=#{id}")
    List<ProductOrder> getOrders(String id);

}
