package com.nvv.itstep.lection.l5_inner_classes.inner.nonstatics.local;

public class Outer {
    private String instanceVariable;

    public void start() {
        String localVariable = "test";

        class Inner {
            String privateInnerField = "private";
            String publicInnerField = "public";

            private void innerMethod() {
                System.out.println(privateInnerField);
                System.out.println(publicInnerField);
                System.out.println(instanceVariable);
                System.out.println(localVariable);
                //localVariable = "test2"//ПОЧЕМУ???
                instanceVariable = "test2";
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();

        System.out.println(inner.publicInnerField);
        System.out.println(inner.privateInnerField);
    }
}
