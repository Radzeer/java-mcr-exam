package hu.training360.validator;

import hu.training360.dto.CreateUserCommand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, CreateUserCommand> {

    @Override
    public boolean isValid(CreateUserCommand command, ConstraintValidatorContext constraintValidatorContext) {
        return command.getEmail().contains("@");
    }

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
