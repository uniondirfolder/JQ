package com.nvv.itstep.lection.l5_inner_classes.inheritance;

public class Parent {
    public int publicParentField;
    public static int staticPublicParentField = 111;

    {
        System.out.println("non static block Parent");
    }

    static {
        System.out.println(staticPublicParentField);
        staticPublicParentField = 222;
        System.out.println(staticPublicParentField);
        System.out.println("static block Parent");
    }

    public Parent() {
        System.out.println("constructor Parent");
    }
}
