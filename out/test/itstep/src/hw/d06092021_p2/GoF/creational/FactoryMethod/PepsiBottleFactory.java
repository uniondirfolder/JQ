package hw.d06092021_p2.GoF.creational.FactoryMethod;

public class PepsiBottleFactory implements DeveloperFactory{

    @Override
    public Developer createDeveloper() {
        return new PepsiBottle();
    }
}
