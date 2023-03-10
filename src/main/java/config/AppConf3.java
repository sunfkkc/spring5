package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.AutowiredSample;
import spring.SomeInjection;

@Configuration
public class AppConf3 {

    @Bean
    public SomeInjection someInjection(){
        return new SomeInjection();
    }

    @Bean
    public AutowiredSample autowiredSample(){
        AutowiredSample autowiredSample = new AutowiredSample();
        autowiredSample.setSomeInjection(someInjection());
        return autowiredSample;
    }
}
