package lection.l4_oop2.aggregation;

public class Car {
    private int price;
    private String model;
    private Body body;
    private Engine engine;
    private Transmission transmission;

    public Car(int price, String model, Body body, Engine engine, Transmission transmission) {
        this.price = price;
        this.model = model;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", body=" + body +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
