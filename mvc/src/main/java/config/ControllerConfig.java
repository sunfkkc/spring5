package config;

import controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap09.HelloController;

@Configuration
public class ControllerConfig {

    @Bean
    public RegisterController registerController(){
        return new RegisterController();
    }

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

}