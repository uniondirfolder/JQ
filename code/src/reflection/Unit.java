package reflection;

public class Unit {
    private int privateField;
    int defaultField;
    public int publicField;

    public Unit(int privateField, int defaultField, int publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.publicField = publicField;
    }

    public Unit() {
    }

    public final void publicGo(){
        System.out.println("unit -> Go");
    }

    private void privateStop(){
        System.out.println("unit -> Stop");
    }
}
