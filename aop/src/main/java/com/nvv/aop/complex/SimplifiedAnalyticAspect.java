package com.nvv.aop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(200)
public class SimplifiedAnalyticAspect {
    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод (Аналитика)");
    }
}
