package com.rwandageodata.validators;

import com.rwandageodata.RwandaGeoData;
import com.rwandageodata.constraints.ValidRwandaVillage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RwandaVillageValidator implements ConstraintValidator<ValidRwandaVillage, String> {
    @Override
    public boolean isValid(String villageName, ConstraintValidatorContext context) {
        return RwandaGeoData
                .getAllVillages()
                .stream()
                .anyMatch(village -> village.equals(villageName));

    }
}
