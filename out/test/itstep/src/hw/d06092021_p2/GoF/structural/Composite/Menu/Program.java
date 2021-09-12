package hw.d06092021_p2.GoF.structural.Composite.Menu;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        MenuComponent first = new MenuItemFirst("Суп харчо");
        MenuComponent second = new MenuItemSecond("Запеканка");
        MenuComponent kompot = new MenuItemKompot("Компот с изюмом");

        ArrayList<MenuComponent> components = new ArrayList<>();
        components.add(first);
        components.add(second);
        components.add(kompot);
        MenuComponent lunch = new Menu("Комплексный обед", components );

        lunch.print();
    }
}
