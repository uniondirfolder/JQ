package hw.d06092021_p2.GoF.behavioral.Visitor;

public class Junior implements Developer {

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing hard code.");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database.");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating not reliable test...");
    }
}
