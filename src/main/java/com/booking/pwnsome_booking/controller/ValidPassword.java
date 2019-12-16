package com.booking.pwnsome_booking.controller;

import org.assertj.core.util.diff.*;

import javax.validation.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;

@Target(value = {TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
