package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest request = (RegisterRequest) target;
        if( request.getEmail() == null || request.getEmail().trim().isEmpty()){
            System.out.println("operate email validation");
            errors.rejectValue("email","email","필수사항");
        }
    }
}
