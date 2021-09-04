package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Composite.Menu;

public class MenuItemKompot implements MenuComponent {
    private String name;

    public MenuItemKompot(String name) {
        this.name = name;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        System.out.println("Третье блюдо: " + name);
    }
}