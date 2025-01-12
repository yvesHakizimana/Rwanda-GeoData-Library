package com.rwandageodata.constraints;

import com.rwandageodata.validators.RwandaLocationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RwandaLocationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRwandaLocation {
    String message() default "Invalid Rwanda Location";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
