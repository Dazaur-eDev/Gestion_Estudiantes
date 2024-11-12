package com.daza.m6_sistemacalificacionesevfinal.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RutValidator implements ConstraintValidator<ValidRut, String> {

    @Override
    public boolean isValid(String rut, ConstraintValidatorContext constraintValidatorContext) {
        return rut.matches( "^\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}$");
    }
}
