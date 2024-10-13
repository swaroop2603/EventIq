package com.EventIq.EventIq.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AgeValidatorImpl implements ConstraintValidator<AgeValidator,LocalDate> {


    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        LocalDate presentDateTime = LocalDate.now();
        int yearsDifference = presentDateTime.getYear() - value.getYear();

        // If the current date is before the person's birthday in the current year, subtract one from the yearsDifference
        if (presentDateTime.getMonthValue() < value.getMonthValue() ||
                (presentDateTime.getMonthValue() == value.getMonthValue() && presentDateTime.getDayOfMonth() < value.getDayOfMonth())) {
            yearsDifference--;
        }

        // Return true if the person is at least 18 years old
        return yearsDifference >= 18;
    }
}
