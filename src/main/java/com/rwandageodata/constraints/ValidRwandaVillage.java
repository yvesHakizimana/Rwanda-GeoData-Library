package com.rwandageodata.constraints;

import com.rwandageodata.validators.RwandaVillageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RwandaVillageValidator.class)
public @interface ValidRwandaVillage {
    String message() default "Invalid Rwanda village name.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
