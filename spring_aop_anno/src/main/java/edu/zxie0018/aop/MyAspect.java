package edu.zxie0018.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("execution(* edu.zxie0018.aop.*.*(..))")
    public void before() {
        System.out.println("Before()...");
    }

    @AfterReturning("execution(* edu.zxie0018.aop.*.*(..))")
    public void afterReturning() {
        System.out.println("AfterReturning()...");
    }

    @Around("execution(* edu.zxie0018.aop.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AroundBefore()...");
        Object o = pjp.proceed();
        System.out.println("AroundAfter()...");
        return o;
    }

    @After("execution(* edu.zxie0018.aop.*.*(..))")
    public void after() {
        System.out.println("After()...");
    }

//    @AfterThrowing("execution(* edu.zxie0018.aop.*.*(..))")
    @AfterThrowing("myAspect.myPointcut()")
    public void afterThrowing() {
        System.out.println("AfterThrowing()...");
    }

    @Pointcut("execution(* edu.zxie0018.aop.*.*(..))")
    public void myPointcut() {}
}
