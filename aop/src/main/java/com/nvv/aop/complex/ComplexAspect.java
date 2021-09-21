package com.nvv.aop.complex;

import org.aspectj.lang.annotation.Before;

// @Aspect
// @Component
public class ComplexAspect {
    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод");
    }

    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод (Аналитика)");
    }

    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод (Cloud)");
    }
}
