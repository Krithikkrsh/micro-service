package io.ecom.practice.User.Validations.logic;

import io.ecom.practice.User.Validations.Unique;
import io.ecom.practice.User.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLogic implements ConstraintValidator<Unique, String> {
    @Autowired
    UserMapper mapper;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return mapper.isPresent(s).isEmpty();
    }
}
