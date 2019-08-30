package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.BeforeClass;


@Aspect("myaspect")
public class MyAspect {

    @Pointcut("execution(* service.impl.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void outBefore(){
        System.out.println("before");
    }
}
