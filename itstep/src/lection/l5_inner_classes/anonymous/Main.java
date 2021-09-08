package lection.l5_inner_classes.anonymous;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.first();
        parent.second();


//        anonymous.Child child = new anonymous.Child();
//        child.first();
//        child.second();

        Parent p = new Parent() {
            public String field;

            public void test() {
                System.out.println("test");
            }

            @Override
            public void second() {
                System.out.println("second anonymous");
                test();
                System.out.println(field);
            }
        };
        p.first();
        p.second();
        //p.test();
        //System.out.println(field);

    }
}
