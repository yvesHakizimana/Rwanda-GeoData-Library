import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RwandaProvinceValidator implements ConstraintValidator<ValidRwandaProvince, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RwandaGeoData.getAllProvinces().contains(value);
    }
}
