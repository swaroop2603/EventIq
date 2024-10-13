package com.EventIq.EventIq.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {AgeValidatorImpl.class})
public @interface AgeValidator {
    String message() default "age must be above 18 years";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
