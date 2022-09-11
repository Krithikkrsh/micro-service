package io.ecom.practice.User.dao;

import io.ecom.practice.User.dto.ShippingAddress;
import io.ecom.practice.User.dto.UserDto;
import org.apache.ibatis.annotations.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Insert("insert into users (user_name,user_phone,user_password,created_at,updated_at)" +
            "values (#{userName},#{userPhoneNumber},#{userPassword},#{createdAt},#{updatedAt})")
    void addUser(UserDto dto);

    @Insert("insert into shaddress (house_no,street_name,road_name,land_mark,city,district,state,country,pin_code,user_id) " +
            "values (#{dto.houseNo},#{dto.streetName},#{dto.roadName},#{dto.landMark},#{dto.city},#{dto.district},#{dto.state},#{dto.country},#{dto.pinCode},#{id})")
    void addAddress(ShippingAddress dto,String id);

    @Select("select user_id from users where user_phone=#{number}")
    Optional<Integer> isPresent(String number);


    @Select("select * from users")
    @Results (value = {
            @Result(property = "userPhoneNumber",column = "user_phone"),
            @Result(property = "userAddress", javaType = Optional.class,
                    column = "user_phone", many = @Many(select = "getAddress"))
    })
    List<UserDto> getUsers();

    @Select("select * from shaddress where user_id=#{id}")
    Optional<ShippingAddress> getAddress(String id);
}
