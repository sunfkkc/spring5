package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String form(LoginCommand loginCommand){
        return "login/loginForm";
    }

    @PostMapping
    public String submit(@Valid LoginCommand loginCommand, Errors errors){

        if(errors.hasErrors()){

            return "login/loginForm";
        }

        try{
            AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());

            return "login/loginSuccess";
        }
        catch (WrongIdPasswordException e){
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }

    }
}
