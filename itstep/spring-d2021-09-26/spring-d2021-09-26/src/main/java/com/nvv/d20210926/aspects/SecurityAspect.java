package com.nvv.d20210926.aspects;

import com.nvv.d20210926.implts.UserAop;
import com.nvv.d20210926.logger.LoggerNvv;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Level;


@Aspect
@Order(1)
public class SecurityAspect {

    // ToFuture
    @Around("execution(* com.nvv.d20210926.implts.UserAop.getCurrentUser())")
    public Object aroundSome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        String str = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        Object targetMethodResult = proceedingJoinPoint.proceed(); // many tips there
        long end = System.currentTimeMillis();
        str += "[" + (end - begin) + "] " + proceedingJoinPoint;
        LoggerNvv.getCurrentLogger().log(Level.INFO, str);

        return targetMethodResult;
    }
}
