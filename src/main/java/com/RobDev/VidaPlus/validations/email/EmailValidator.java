package com.RobDev.VidaPlus.validations.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    private String value;

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        this.value = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (value.equals("Update")) {
            if (email == null) {
                return true;
            } else {
                return email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z]+[.][a-zA-Z]{3}$");
            }
        }

        return email != null && email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z]+[.][a-zA-Z]{3}$");

    }
}
