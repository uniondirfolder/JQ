package hw.d06092021_p2.GoF.creational.FactoryMethod;

public class CppDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
