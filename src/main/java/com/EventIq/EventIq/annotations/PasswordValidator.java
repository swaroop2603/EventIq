package com.EventIq.EventIq.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {PasswordValidatorImpl.class})
public @interface PasswordValidator {

    String message() default "password should have letters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
