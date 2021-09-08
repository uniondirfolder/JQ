package hw.d06092021_p2.GoF.structural.Bridge.Car;

public class BMW extends Make {

    public BMW(Model model) {
        super(model);
    }

    @Override
    void showMake() {
        System.out.println("BMW");
    }
}
