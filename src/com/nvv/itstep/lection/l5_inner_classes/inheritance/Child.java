package com.nvv.itstep.lection.l5_inner_classes.inheritance;

public class Child extends Parent {
    public int publicChildField;
    public static int staticPublicChildField = 1;

    {
        System.out.println("non static block Child");
    }

    static {
        System.out.println(staticPublicChildField);
        staticPublicChildField = 2;
        System.out.println(staticPublicChildField);
        System.out.println("static block Child");
    }

    public Child() {
        System.out.println("constructor Child");
    }
}
