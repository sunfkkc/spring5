package config;

import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap09.HelloController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;
    @Autowired
    private AuthService authService;
    @Autowired
    private ChangePasswordService changePasswordService;
    @Autowired
    private MemberDao memberDao;

    @Bean
    public RegisterController registerController(){
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);
        return controller;
    }

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }


    @Bean
    public SurveyController surveyController(){
        return new SurveyController();
    }

    @Bean
    public LoginController loginController(){
        return new LoginController();
    }

    @Bean
    public LogoutController logoutController(){
        return new LogoutController();
    }

    @Bean
    public ChangePwdController changePwdController(){
        return new ChangePwdController();
    }

    @Bean
    public MemberListController memberListController(){
        return new MemberListController();
    }
    @Bean
    public MemberDetailController memberDetailController(){
        return new MemberDetailController();
    }
}