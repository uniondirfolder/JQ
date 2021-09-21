package com.nvv.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


@Aspect
@Order(1)
public class Logger {
    @Value("${logger.file}")
    private String file;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    SimpleDateFormat sdf;

    @Before("com.nvv.aspects.Pointcuts.crudMethods()")
    public void beforeCreateEntity(JoinPoint joinPoint) {
        writeFile("before",joinPoint);
    }

    @After("com.nvv.aspects.Pointcuts.crudMethods()")
    public void afterCreateEntity(JoinPoint joinPoint) {
        writeFile("after", joinPoint);
    }

    private void writeFile(String prefix, JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] arguments = joinPoint.getArgs();
        for (int i = 0; i < arguments.length; i++) {
            pw.println(prefix + " " + methodSignature.getName() + ": " + sdf.format(new Date().getTime()) + " > " + arguments[i] + " ;");
        }
    }

    @PostConstruct
    private void init() {
        System.out.println("Init logger");
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    }

    @PreDestroy
    private void destroy() {
        if (pw != null) {
            pw.close();
        }
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fw != null) {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Destroy logger");
    }

}
