package config;

import AOPSample.Calculator;
import AOPSample.ExeTimeAspect;
import AOPSample.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConf {

    @Bean
    public ExeTimeAspect exeTimeAspect(){
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }

}
