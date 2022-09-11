package io.ecom.practice.Product.Validations;

import io.ecom.practice.Product.Validations.Logic.CreatedLogic;
import io.ecom.practice.Product.Validations.Logic.PhoneLogic;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CreatedLogic.class)
public @interface Created {

    String message() default "Time-Stamp field";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
}
