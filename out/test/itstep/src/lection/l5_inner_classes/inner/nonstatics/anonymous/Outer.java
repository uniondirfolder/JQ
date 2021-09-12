package lection.l5_inner_classes.inner.nonstatics.anonymous;

public class Outer {
private String instanceField = "instanceField";
    Neighbour instanceVariable = new Neighbour(){
        @Override
        public void test() {
            System.out.println("test Neighbour");
            System.out.println(instanceField);
            instanceField = "new";
        }
    };



    public void start() {
        String local = "local";
        Neighbour localVariable = new Neighbour(){
            @Override
            public void showName() {
                System.out.println(instanceField);
                System.out.println(local);
                instanceField = "new";
                //local = "new";
                System.out.println("Neighbour");
            }
        };

    }
}
