package com.nvv.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;


@Aspect
@Order(2)
public class Exceptions {
    @AfterThrowing(pointcut = "execution(* *(..))",throwing = "exception")
    public void afterException(JoinPoint joinPoint, Throwable exception){
        // ToFuture
    }
}
