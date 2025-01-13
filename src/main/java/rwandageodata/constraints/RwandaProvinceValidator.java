package rwandageodata.constraints;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.RwandaGeoDataFactory;

class RwandaProvinceValidator implements ConstraintValidator<ValidRwandaProvince, String> {

    @Override
    public boolean isValid(String provinceName, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .getAllProvinces()
                .stream()
                .anyMatch(province -> province.equalsIgnoreCase(provinceName));
    }
}
