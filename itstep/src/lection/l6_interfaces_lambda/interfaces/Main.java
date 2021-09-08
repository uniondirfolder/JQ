package lection.l6_interfaces_lambda.interfaces;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Man man = new Man("Ivan");
        Woman woman = new Woman();
        Table table = new Table();

        //interfaces.Soldier soldier = new interfaces.Soldier();
        Soldier soldier = man;
        soldier = woman;
        //soldier = new interfaces.Table();

        commander(woman);
        commander(man);
        //commander(table);

        chef(man);
        //chef(woman);
    }

    public static void commander(Soldier soldier) {
        soldier.shoot();
    }

    public static void chef(Cook cook) {
        cook.cook();
    }



}
