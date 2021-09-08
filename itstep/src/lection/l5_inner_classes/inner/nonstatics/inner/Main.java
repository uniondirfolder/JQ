package lection.l5_inner_classes.inner.nonstatics.inner;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerMethod();
        //Inner inner = new Inner();
        //Outer.Inner inner = outer.new Inner();

        Outer.Inner inner = new Outer().new Inner();
        System.out.println(inner.innerPublicField);
        //System.out.println(inner.innerPrivateField);
        //System.out.println(inner.outerPublicField);
    }
}
