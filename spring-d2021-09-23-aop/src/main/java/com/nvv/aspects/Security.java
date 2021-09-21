package com.nvv.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;


@Aspect
@Order(3)
public class Security {
 // ToFuture
//    @Around("execution(public * userDoSomeThing())")
//    public Object aroundSome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        Object targetMethodResult = proceedingJoinPoint.proceed(); // many tips there
//        // bill vasya stala masha
//        return targetMethodResult;
//    }
}
