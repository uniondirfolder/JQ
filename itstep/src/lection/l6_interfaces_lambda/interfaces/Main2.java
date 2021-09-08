package lection.l6_interfaces_lambda.interfaces;

public class Main2 {
    public static void main(String[] args) {
        Soldier soldier = new Soldier() {
            @Override
            public void shoot() {
                System.out.println("Тихонечко стреляет");
            }
        };

        soldier.shoot();
        soldier.printHello();
    }
}
