package com.nvv.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogRepo {

    @Around("execution(* com.nvv.dao.*.*(..))")
    public Object aroundAllRepoAdvice(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        MethodSignature methodSignature= (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        return targetMethodResult;
    }
}
