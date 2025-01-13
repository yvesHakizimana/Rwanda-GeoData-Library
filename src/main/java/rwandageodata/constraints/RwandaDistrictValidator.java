package rwandageodata.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.RwandaGeoDataFactory;

class RwandaDistrictValidator implements ConstraintValidator<ValidRwandaDistrict, String> {
    @Override
    public boolean isValid(String districtName, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .getAllDistricts()
                .stream()
                .anyMatch(district -> district.equalsIgnoreCase(districtName));
    }
}
