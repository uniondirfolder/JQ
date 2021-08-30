package com.nvv.itstep.lection.l5_inner_classes.inner.nonstatics.inner;

public class Outer {//1    2
    private String outerPrivateField;
    public String outerPublicField;
    public String test = "Outer";

    public Outer() {
        System.out.println("Outer");
    }

    public void outerMethod() {
        //System.out.println(innerPublicField);
        //System.out.println(innerPrivateField);

        Inner inner = new Inner();
        System.out.println(inner.innerPublicField);
        System.out.println(inner.innerPrivateField);
    }

    public class Inner{//1   2
        private String innerPrivateField;
        public String innerPublicField;
        public String test = "Inner";

        public Inner() {
            System.out.println("Inner");
        }

        public void innerMethod() {
            System.out.println(outerPublicField);
            System.out.println(outerPrivateField);

            System.out.println(test);
            System.out.println(Outer.this.test);

            Outer outer = new Outer();
            System.out.println(outer.outerPrivateField);
            System.out.println(outer.outerPrivateField);

        }
    }
}
