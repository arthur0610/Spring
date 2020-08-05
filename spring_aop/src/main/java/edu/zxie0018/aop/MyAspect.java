package edu.zxie0018.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before() {
        System.out.println("Before()...");
    }

    public void afterReturning() {
        System.out.println("AfterReturning()...");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AroundBefore()...");
        Object o = pjp.proceed();
        System.out.println("AroundAfter()...");
        return o;
    }

    public void after() {
        System.out.println("After()...");
    }

    public void afterThrowing() {
        System.out.println("AfterThrowing()...");
    }
}
