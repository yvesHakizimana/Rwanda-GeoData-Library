package rwandageodata.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a field contains a valid Rwanda Location which contains province, district, sector, cell and also village.
 * This annotation is used with {@link RwandaLocationValidator} to enforce the validation logic.
 */
@Constraint(validatedBy = RwandaLocationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRwandaLocation {
    /**
     * Specifies the error message to be displayed if the validation fails.
     *
     * @return the default error message.
     */
    String message() default "Invalid Rwanda Location";

    /**
     * Specifies the error message to be displayed if the validation fails.
     *
     * @return the default error message.
     */
    Class<?>[] groups() default {};

    /**
     * Specifies the payload associated with the constraint.
     * Payloads can be used by clients to provide custom error handling or severity levels.
     *
     * @return an array of payload classes.
     */
    Class<? extends Payload>[] payload() default {};
}
