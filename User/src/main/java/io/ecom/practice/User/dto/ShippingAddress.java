package io.ecom.practice.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    @NotNull
    private String houseNo;
    @NotNull
    private String landMark;
    @NotNull
    private String streetName;
    @NotNull
    private String roadName;
    @NotNull
    private String city;
    @NotNull
    private String district;
    @NotNull
    private String state;
    @NotNull
    private String country;
    @NotNull
    private String pinCode;
}
