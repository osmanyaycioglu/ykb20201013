package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckStartValidation implements ConstraintValidator<StringStartValidation, String> {

    private StringStartValidation constraintAnnotation;

    @Override
    public void initialize(final StringStartValidation constraintAnnotationParam) {
        this.constraintAnnotation = constraintAnnotationParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.constraintAnnotation.startMy());
    }

}
