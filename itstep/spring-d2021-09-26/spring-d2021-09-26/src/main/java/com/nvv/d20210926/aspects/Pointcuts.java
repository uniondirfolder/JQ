package com.nvv.d20210926.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("allCreateMethods() || allReadMethods() || allUpdateMethods() || allDeleteMethods()")
    public void crudMethods(){}

    @Pointcut("execution(* create*(..))")
    public void allCreateMethods(){}

    @Pointcut("execution(* read*(..))")
    public void allReadMethods(){}

    @Pointcut("execution(* update*(..))")
    public void allUpdateMethods(){}

    @Pointcut("execution(* delete*(..))")
    public void allDeleteMethods(){}

}
