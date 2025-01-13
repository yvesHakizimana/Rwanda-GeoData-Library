package rwandageodata.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.RwandaGeoDataFactory;

class RwandaVillageValidator implements ConstraintValidator<ValidRwandaVillage, String> {
    @Override
    public boolean isValid(String villageName, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .getAllVillages()
                .stream()
                .anyMatch(village -> village.equalsIgnoreCase(villageName));
    }
}
