package hw.d06092021_p2.GoF.creational.AbstractFactory.banking;


import hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Java developer write banking code");
    }
}
