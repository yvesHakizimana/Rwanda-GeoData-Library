package rwandageodata.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.Location;
import rwandageodata.RwandaGeoDataFactory;

class RwandaLocationValidator implements ConstraintValidator<ValidRwandaLocation, Location> {
    @Override
    public boolean isValid(Location rwandaLocation, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .locationExists(rwandaLocation);
    }
}
