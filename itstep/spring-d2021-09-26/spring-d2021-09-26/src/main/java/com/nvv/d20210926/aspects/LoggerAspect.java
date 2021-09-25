package com.nvv.d20210926.aspects;

import com.nvv.d20210926.logger.LoggerNvv;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import java.util.logging.Level;


@Aspect
@Order(2)
public class LoggerAspect {

    @Before("com.nvv.d20210926.aspects.Pointcuts.crudMethods()")
    public void beforeCreateEntity(JoinPoint joinPoint) {
        writeFile("before", joinPoint);
    }

    @After("com.nvv.d20210926.aspects.Pointcuts.crudMethods()")
    public void afterCreateEntity(JoinPoint joinPoint) {
        writeFile("after", joinPoint);
    }

    private void writeFile(String prefix, JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] arguments = joinPoint.getArgs();
        for (int i = 0; i < arguments.length; i++) {
            try {
                String str = prefix + " |> " + methodSignature.getName() + " <" + arguments[i] + ">";
                LoggerNvv.getCurrentLogger().log(Level.INFO, str);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
