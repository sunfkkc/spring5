package main;

import AOPSample.Calculator;
import AOPSample.RecCalculator;
import config.AOPConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForAOP {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConf.class);

        Calculator calculator = context.getBean( RecCalculator.class);

        long result = calculator.factorial(10);
        System.out.println("10팩토리얼 :"+result);
        System.out.println(calculator.getClass().getName());

        context.close();
    }
}
