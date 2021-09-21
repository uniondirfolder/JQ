package com.nvv.aop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(-100)
public class SimplifiedLoggingAspect {
    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод (Logging)");
    }
}
