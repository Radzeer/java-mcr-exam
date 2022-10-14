package hu.training360.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {

    String message() default "invalid email address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
