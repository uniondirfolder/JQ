package hw.d06092021_p2.GoF.structural.Adapter;

public class AdapterOne implements Database {
    JavaApplication javaApplication;

    public AdapterOne(JavaApplication javaApplication) {
        this.javaApplication = javaApplication;
    }

    @Override
    public void insert() {
        javaApplication.saveObject();
    }

    @Override
    public void select() {
        javaApplication.readObject();
    }

    @Override
    public void update() {
        javaApplication.changeObject();
    }

    @Override
    public void delete() {
        javaApplication.removeObject();
    }
}
