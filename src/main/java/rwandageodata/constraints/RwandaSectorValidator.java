package rwandageodata.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.RwandaGeoDataFactory;

class RwandaSectorValidator implements ConstraintValidator<ValidRwandaSector, String> {

    @Override
    public boolean isValid(String sectorName, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .getAllSectors()
                .stream()
                .anyMatch(sector -> sector.equalsIgnoreCase(sectorName));
    }
}
