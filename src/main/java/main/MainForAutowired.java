package main;

import config.AppConf3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.AutowiredSample;

public class MainForAutowired {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf3.class);

        AutowiredSample autowiredSample = context.getBean("autowiredSample", AutowiredSample.class);

        autowiredSample.print();
    }
}
