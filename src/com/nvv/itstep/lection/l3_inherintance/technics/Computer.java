package com.nvv.itstep.lection.l3_inherintance.technics;

public class Computer {
    //ctrl + O переопределить метды
    private String model;
    private int cpuFrequency;///1000
    protected int ram;
    protected String test = "Parent";

    //alt + insert - генерация конструкторов и методов


    public Computer() {

//        this.model = "model";
//        this.cpuFrequency = 1000;
//        ram = 1;
        this("model", 1000, 1);//ctrl+P
        System.out.println("Computer");
//        System.out.println(ram);


//        int ram = 100;
//        System.out.println(ram);
//        System.out.println(this.ram);
//        System.out.println(this);
    }

    public Computer(String model, int cpuFrequency, int ram) {
        System.out.println("Computer");

        this.model = model;
        this.cpuFrequency = cpuFrequency;
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(int cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void overclock(int percent) {
        cpuFrequency = cpuFrequency * (percent + 100) / 100;
        //cpuFrequency += cpuFrequency * (double) percent / 100;
    }

    public void info() {
        System.out.println(model + cpuFrequency + ram);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "model='" + model + '\'' +
                ", cpuFrequency=" + cpuFrequency +
                ", ram=" + ram +
                '}';
    }
}
