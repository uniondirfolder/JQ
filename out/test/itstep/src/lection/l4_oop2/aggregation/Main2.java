package lection.l4_oop2.aggregation;

public class Main2 {
    public static void main(String[] args) {
        Car car = new Car(
                40_000,
                "X5",
                new Body("Black", "Jip"),
                new Engine(380, "oil", 20),
                new Transmission(7, "auto"));
        Engine engine = car.getEngine();

        car = null;
        //System.gc();
        System.out.println(engine.getConsumption());


        //System.out.println(car.getEngine().getConsumption());
    }
}
