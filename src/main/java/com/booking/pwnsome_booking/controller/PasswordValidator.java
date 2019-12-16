package com.booking.pwnsome_booking.controller;

import javax.validation.*;
import java.util.regex.*;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {


    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "(.*[A-Z].*[0-9].*)*(.*[0-9].*[A-Z].*)*";


    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return validatePassword(password);
    }

    public boolean validatePassword(String password){
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        System.out.print(matcher.matches());
        return matcher.matches();
    }

}
