package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.AutowiredSample;
import spring.SomeInjection;

@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppConf3 {

    @Bean
    public SomeInjection someInjection(){
        return new SomeInjection("setter");
    }

//    @Bean
//    public AutowiredSample autowiredSample(){
//        AutowiredSample autowiredSample = new AutowiredSample();
//        return autowiredSample;
//    }
}
