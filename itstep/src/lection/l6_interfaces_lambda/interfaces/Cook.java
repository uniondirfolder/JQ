package lection.l6_interfaces_lambda.interfaces;

public interface Cook {
    void cook();
    default void printHello() {
        System.out.println("Hello from interfaces.Cook!");
    }
}
