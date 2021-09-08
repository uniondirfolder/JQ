package hw.d06092021_p2.GoF.creational.FactoryMethod;

public class PhpDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }
}
