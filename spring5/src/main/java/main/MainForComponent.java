package main;

import config.AppConf3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.AutowiredSample;

public class MainForComponent {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf3.class);

        AutowiredSample sample = ctx.getBean(AutowiredSample.class);

        sample.print();
    }
}
