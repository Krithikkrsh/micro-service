package io.ecom.practice.User.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ecom.practice.User.Validations.Unique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private int userId;
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    @Unique(message = "Phone Number already exists")
    private String userPhoneNumber;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z][a-zA-Z0-9]{7,}$",message = "Password should contains 6 characters with caps and small and symbol")
    private String userPassword;
    @Valid
    private ShippingAddress userAddress;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
