package com.RobDev.VidaPlus.validations.email;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValid {

    String message() default "Email invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
