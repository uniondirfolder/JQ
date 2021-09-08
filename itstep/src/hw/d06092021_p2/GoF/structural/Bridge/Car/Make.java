package hw.d06092021_p2.GoF.structural.Bridge.Car;

public abstract class Make {
    Model model;

    public Make(Model model) {
        this.model = model;
    }

    abstract void showMake();
    
    void showDetales() {
        showMake();
        model.showModel();
    }
}
