package hw.d06092021_p2.GoF.creational.AbstractFactory.auto;

public class FerrariFactory implements AutoFactory{

    @Override
    public Carcase getCarcase() {
        return new FerrariCarcase();
    }

    @Override
    public Motor getMotor() {
        return new FerrariMotor();
    }

    @Override
    public Chassis getChassis() {
        return new FerrariChassis();
    }
}
