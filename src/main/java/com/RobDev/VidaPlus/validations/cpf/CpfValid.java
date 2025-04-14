package com.RobDev.VidaPlus.validations.cpf;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {

    String message() default "CPF invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
