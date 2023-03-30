package AOPSample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {

    @Pointcut("execution(public * AOPSample..*(..))")
    private void publicTarget(){}

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.nanoTime();

        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {

            long finish = System.nanoTime();
            System.out.println("실행시간"+(finish - start));
        }
    }
}
