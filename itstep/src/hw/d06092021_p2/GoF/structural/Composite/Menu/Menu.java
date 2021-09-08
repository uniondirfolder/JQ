package hw.d06092021_p2.GoF.structural.Composite.Menu;

import java.util.ArrayList;

public class Menu implements MenuComponent {
    private String name;
    private ArrayList<MenuComponent> components;

    public Menu(String name, ArrayList<MenuComponent> components) {
        this.name = name;
        this.components = components;
    }

    public ArrayList<MenuComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<MenuComponent> components) {
        this.components = components;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        components.add(menuComponent);
    }

    @Override
    public void print() {
        System.out.println("Обеденное меню " + name + "\n*******************************");
        for (MenuComponent component : components) {
            component.print();
        }
    }
}
