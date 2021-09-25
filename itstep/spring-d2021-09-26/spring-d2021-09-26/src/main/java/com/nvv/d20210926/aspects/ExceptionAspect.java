package com.nvv.d20210926.aspects;

import com.nvv.d20210926.logger.LoggerNvv;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Level;
import java.util.logging.Logger;


@Aspect
@Order(3)
public class ExceptionAspect {
    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "exception")
    public void afterException(JoinPoint joinPoint, Throwable exception)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("signature: " + joinPoint.getSignature().getName() + " / ");
        Object[] obj = joinPoint.getArgs();
        sb.append("args: ");
        for (Object o : obj) {
            sb.append(o);
            sb.append(" ");
        }
        sb.append(" / ");
        sb.append(exception.getMessage());
        try {
            Logger  log = LoggerNvv.getCurrentLogger();
            log.log(Level.WARNING, sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
