package hw.d06092021_p2.GoF.behavioral.Visitor;

public class Senior implements Developer {

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Refactoring code after jun.");
    }

    @Override
    public void create(Database database) {
        System.out.println("Fixing bugs in database.");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating reliable test.");
    }
}
