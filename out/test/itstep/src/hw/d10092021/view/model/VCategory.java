package hw.d10092021.view.model;

public class VCategory {
    private long id;
    private String name;

    public VCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
