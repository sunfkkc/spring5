package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.AutowiredSample;
import spring.SomeInjection;

@Configuration
@ComponentScan(basePackages = {"spring"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring\\..*Sample"))
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
