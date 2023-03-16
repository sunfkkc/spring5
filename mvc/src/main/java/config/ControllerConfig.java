package config;

import controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap09.HelloController;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

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

}