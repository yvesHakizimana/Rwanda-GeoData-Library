package com.rwandageodata.validators;

import com.rwandageodata.Location;
import com.rwandageodata.RwandaGeoData;
import com.rwandageodata.constraints.ValidRwandaLocation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RwandaLocationValidator implements ConstraintValidator<ValidRwandaLocation, Location> {
    @Override
    public boolean isValid(Location rwandaLocation, ConstraintValidatorContext context) {
        return RwandaGeoData.locationExists(rwandaLocation);
    }
}
