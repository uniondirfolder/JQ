package com.nvv.aop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(1000)
public class SimplifiedCloudAspect {
    @Before("execution(public * com.nvv.aop.com.nvv.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе com.nvv.aop.UserDAO вызывают метод (Cloud)");
    }
}
