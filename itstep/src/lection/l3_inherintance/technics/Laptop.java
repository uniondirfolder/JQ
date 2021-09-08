package lection.l3_inherintance.technics;

public class Laptop extends Computer {
    private int batteryCapacity;
    private double weight;
    private String test = "Child";

    public Laptop() {
        //System.out.println(ram);
    }

    public Laptop(String model, int cpuFrequency, int ram, int batteryCapacity, double weight) {
        super(model, cpuFrequency, ram);
        this.batteryCapacity = batteryCapacity;
        this.weight = weight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

//    @Override
//    public String toString() {
//        return "Laptop{" +
//                "batteryCapacity=" + batteryCapacity +
//                ", weight=" + weight +
//                '}';
//    }


    public void printName() {
        System.out.println(test);
        System.out.println(super.test);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", weight=" + weight +
                "} " + super.toString();
    }

    @Override
    public void overclock(int cpuFrequency) {
        setCpuFrequency(getCpuFrequency() + cpuFrequency);
    }

}
