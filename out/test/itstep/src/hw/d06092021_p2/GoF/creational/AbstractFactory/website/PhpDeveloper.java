package hw.d06092021_p2.GoF.creational.AbstractFactory.website;


import hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;

public class PhpDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Php developer write website code");
    }
}
