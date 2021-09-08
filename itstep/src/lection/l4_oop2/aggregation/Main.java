package lection.l4_oop2.aggregation;

public class Main {
    public static void main(String[] args) {
        Body body = new Body("Black", "Jip");
        Engine engine = new Engine(380, "oil", 20);
        Transmission transmission = new Transmission(7, "auto");
        Car car = new Car(40_000, "X5", body, engine, transmission);

        System.out.println(car);
        car.setPrice(35000);
        System.out.println(car);
        car.setPrice(car.getPrice() * 2);
        System.out.println(car);
        //car.getBody().setColor("white");
        body.setColor("white");
        System.out.println(car);
        //engine.setConsumption(engine.getConsumption() - 2);
        car.getEngine().setConsumption(engine.getConsumption() - 2);

        car = null;
        //car.getBody().getColor();
        System.out.println(body.getColor());

    }

}
