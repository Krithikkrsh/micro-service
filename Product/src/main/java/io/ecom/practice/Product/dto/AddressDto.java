package io.ecom.practice.Product.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
    * This class is created as address object
    * Note all the fields should
 * @author krsh
 * @version 17.0
 */

@Data
public class AddressDto {
    @NotNull(message = "Please Enter Shop Number")
    @NotEmpty
    private String shopNo;
    @NotEmpty
    @NotNull(message = "Please Enter Street Name")
    private String streetName;
    @NotEmpty
    private String roadName;
    @NotEmpty
    private String landMark;
    @NotEmpty
    @NotNull(message = "Please Enter City")
    private String city;
    @NotEmpty
    @NotNull(message = "Please Enter District")
    private String district;
    @NotEmpty
    @NotNull(message = "Please Enter State")
    private String state;
    @NotEmpty
    @NotNull(message = "Please Enter Country")
    private String country;
    @NotEmpty
    @NotNull(message = "Please Enter PinCode")
    private String pinCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
