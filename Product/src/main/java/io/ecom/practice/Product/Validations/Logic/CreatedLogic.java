package io.ecom.practice.Product.Validations.Logic;

import io.ecom.practice.Product.Validations.Created;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Timestamp;
import java.time.Instant;

public class CreatedLogic implements ConstraintValidator<Created, Timestamp> {
    @Override
    public boolean isValid(Timestamp timestamp, ConstraintValidatorContext constraintValidatorContext) {
        if (timestamp == null)
            timestamp = Timestamp.from(Instant.now());
        return false;
    }
}
