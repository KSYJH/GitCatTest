package me.yjh.demospring8bu.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","not empty","Empty title is now allow");
    }
}
