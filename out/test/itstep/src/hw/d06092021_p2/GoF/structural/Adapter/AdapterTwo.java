package hw.d06092021_p2.GoF.structural.Adapter;

public class AdapterTwo extends JavaApplication implements Database {

    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void select() {
        readObject();
    }

    @Override
    public void update() {
        changeObject();
    }

    @Override
    public void delete() {
        removeObject();
    }
}
