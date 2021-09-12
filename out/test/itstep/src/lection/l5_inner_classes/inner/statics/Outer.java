package lection.l5_inner_classes.inner.statics;

public class Outer {
    private String outerPrivateField;
    public String outerPublicField;

    public Outer() {
        System.out.println("Outer");
    }

    public void outerMethod() {
//        System.out.println(innerPublicField);
//        System.out.println(innerPrivateField);

        Inner inner = new Inner();
        System.out.println(inner.innerPrivateField);
        System.out.println(inner.innerPublicField);

    }

    public static class Inner {
        private String innerPrivateField;
        public String innerPublicField;

        public Inner() {
            System.out.println("Inner");
        }



        public void innerMethod() {
//            System.out.println(outerPrivateField);
//            System.out.println(outerPublicField);

            Outer outer = new Outer();
            System.out.println(outer.outerPublicField);
            System.out.println(outer.outerPrivateField);
        }
    }
}
