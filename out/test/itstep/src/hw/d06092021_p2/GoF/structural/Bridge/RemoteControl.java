package hw.d06092021_p2.GoF.structural.Bridge;

public abstract class RemoteControl {
    protected TVset tvSet;
    
    protected RemoteControl(TVset tvSet) {
        this.tvSet = tvSet;
    }
    abstract void on();
    abstract void off();
    abstract void setChannel(int channel);
}
