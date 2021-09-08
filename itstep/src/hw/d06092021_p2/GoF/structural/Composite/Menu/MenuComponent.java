package hw.d06092021_p2.GoF.structural.Composite.Menu;

public interface MenuComponent {
    String getName();
    void add(MenuComponent menuComponent);
    void print();
}
