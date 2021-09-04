package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod;

public class Program {

    public static void main(String[] args) {
        DeveloperFactory developerFactory = CreateDeveloperFactoryBySpecialty("cola");
//        DeveloperFactory developerFactory = new JavaDeveloperFactory();
//        DeveloperFactory developerFactory = new CppDeveloperFactory();
//        DeveloperFactory developerFactory = new PhpDeveloperFactory();
        Developer developer = developerFactory.createDeveloper();

        developer.writeCode();
    }

    static DeveloperFactory CreateDeveloperFactoryBySpecialty(String specialty) {
        if(specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if(specialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else if(specialty.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else if(specialty.equalsIgnoreCase("cola")) {
            return new ColaBottleFactory();
        } else if(specialty.equalsIgnoreCase("pepsi")) {
            return new PepsiBottleFactory();
        } else {
            throw new RuntimeException(specialty + " - is unknown specialty!!!");
        }
    }
}
