package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.auto;

public class Program {

    public static void main(String[] args) {
        AutoFactory autoFactory = new FerrariFactory();
        Carcase carcase = autoFactory.getCarcase();
        Chassis chassis = autoFactory.getChassis();
        Motor motor = autoFactory.getMotor();
        
        System.out.println("Create Ferrari AUTO");
        System.out.println("===================");
        
        carcase.createCarcase();
        chassis.createChassis();
        motor.createMotor();
    }

}
