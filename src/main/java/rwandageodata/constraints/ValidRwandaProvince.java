package rwandageodata.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a field contains a valid Rwanda province name.
 * This annotation is used with {@link RwandaProvinceValidator} to enforce the validation logic.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RwandaProvinceValidator.class)
public @interface ValidRwandaProvince {
    /**
     * Specifies the error message to be displayed if the validation fails.
     *
     * @return the default error message.
     */
    String message() default "Invalid Rwanda Province name";

    /**
     * Specifies the validation groups the constraint belongs to.
     * This allows grouping constraints together to apply them conditionally.
     *
     * @return an array of classes representing the groups.
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
