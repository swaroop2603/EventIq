package com.EventIq.EventIq.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?/~`|\\\\-]).*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
