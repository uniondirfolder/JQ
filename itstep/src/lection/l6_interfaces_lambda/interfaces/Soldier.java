package lection.l6_interfaces_lambda.interfaces;

public interface Soldier {
   public static final int CAPITAN = 1;
    void shoot();

    default void printHello() {
        System.out.println("Hello from interfaces.Soldier!");
    }

}