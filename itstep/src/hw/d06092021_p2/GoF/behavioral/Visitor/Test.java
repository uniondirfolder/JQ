package hw.d06092021_p2.GoF.behavioral.Visitor;

public class Test implements ProjectElement {

    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
