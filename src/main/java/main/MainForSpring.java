package main;

import config.AppConf1;
import config.AppConf2;
import config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainForSpring {

    private static ApplicationContext ctx;
    public static void main(String[] args) throws IOException {

        ctx = new AnnotationConfigApplicationContext(AppCtx.class);


    }
}
