package hw.d06092021_p2.GoF.structural.Bridge;

public class StandardRemoteC extends RemoteControl {
    int channel;

    protected StandardRemoteC(TVset tvSet) {
        super(tvSet);
        this.channel = 1;
    }

    @Override
    public void on() {
        System.out.println("Button on were pushed");
        tvSet.on();
    }

    @Override
    public void off() {
        System.out.println("Button off were pushed");
        tvSet.off();
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        tvSet.tuneChannel();
    }

    public TVset getTvSet() {
        return tvSet;
    }

    public int getChannel() {
        return channel;
    }
}
