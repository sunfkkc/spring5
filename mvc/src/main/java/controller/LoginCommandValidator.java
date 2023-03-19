package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        //공백을 체크하여 메시지를 출력하는 로직
    }
}
