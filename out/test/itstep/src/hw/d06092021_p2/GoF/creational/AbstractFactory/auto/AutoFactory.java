package hw.d06092021_p2.GoF.creational.AbstractFactory.auto;

public interface AutoFactory {
    Carcase getCarcase();
    Motor getMotor();
    Chassis getChassis();
}
