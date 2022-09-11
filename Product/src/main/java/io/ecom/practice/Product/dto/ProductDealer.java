package io.ecom.practice.Product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ecom.practice.Product.Validations.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * This is a Product-dealer POJO
 * All Fields are Not Null fields
 *
 * For dealer address
 * @author krshk
 * @see AddressDto
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDealer {
    @JsonIgnore
    private String dealerID;
    @NotNull(message = "Please Enter Dealer Name")
    @NotEmpty
    private String dealerName;
    @NotNull(message = "Please Enter Phone Number")
    @Phone
    private String dealerPhoneNumber;
    @Valid
    private AddressDto dealerAddress;
    @NotNull(message = "Password should not be null")
    @NotEmpty
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z][a-zA-Z0-9]{7,}$",message = "Password should contains 6 characters with caps and small and symbol")
    private String dealerPassword = "none";
    @JsonIgnore
    private Timestamp createdAt;
    @JsonIgnore
    private Timestamp updatedAt;
}
