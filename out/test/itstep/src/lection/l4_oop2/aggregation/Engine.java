package lection.l4_oop2.aggregation;

public class Engine {
    private int horsePower;
    private String type;
    private double consumption;//расход

    public Engine(int horsePower, String type, double consumption) {
        this.horsePower = horsePower;
        this.type = type;
        this.consumption = consumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + horsePower +
                ", type='" + type + '\'' +
                ", consumption=" + consumption +
                '}';
    }
}
