package com.rwandageodata.validators;

import com.rwandageodata.RwandaGeoData;
import com.rwandageodata.constraints.ValidRwandaCell;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RwandaCellValidator implements ConstraintValidator<ValidRwandaCell, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RwandaGeoData.getAllCells().contains(value);
    }
}