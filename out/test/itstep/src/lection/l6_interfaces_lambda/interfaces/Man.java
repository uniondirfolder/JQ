package lection.l6_interfaces_lambda.interfaces;

public class Man implements Soldier, Cook{
    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        System.out.println("Метко стреляю");
    }

    @Override
    public void printHello() {
        Soldier.super.printHello();
        Cook.super.printHello();
    }

    @Override
    public void cook() {
        System.out.println("Вкусно готовлю");
    }
}
