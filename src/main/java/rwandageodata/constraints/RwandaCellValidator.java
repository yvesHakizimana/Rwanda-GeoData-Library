package rwandageodata.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rwandageodata.RwandaGeoDataFactory;

class RwandaCellValidator implements ConstraintValidator<ValidRwandaCell, String> {

    @Override
    public boolean isValid(String cellName, ConstraintValidatorContext context) {
        return RwandaGeoDataFactory
                .create()
                .getAllCells()
                .stream()
                .anyMatch(cell -> cell.equalsIgnoreCase(cellName));
    }
}
