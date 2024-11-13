package com.daza.m6_sistemacalificacionesevfinal.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RutValidator implements ConstraintValidator<ValidRut, String> {

    @Override
    public void initialize(ValidRut constraintAnnotation) {
    }

    @Override
    public boolean isValid(String rut, ConstraintValidatorContext context) {
        if (rut == null || rut.isEmpty()) {
            return false;
        } else {
        return rut.matches("^[0-9]{1,2}\\.?[0-9]{3}\\.?[0-9]{3}-[0-9kK]{1}$");
        }
    }
}
