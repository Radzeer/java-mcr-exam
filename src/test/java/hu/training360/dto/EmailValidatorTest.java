package hu.training360.dto;

import hu.training360.validator.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {

    @Test
    void testCreateUserCommandValid(){
        assertTrue(new EmailValidator().isValid(new CreateUserCommand("sample@sample.com"),null));
    }

    @Test
    void testCreateUserCommandNotValid(){
        assertFalse(new EmailValidator().isValid(new CreateUserCommand("samplesample.com"),null));
    }
}
