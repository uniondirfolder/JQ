package hw.d06092021_p2.GoF.structural.Bridge;

public class Program {

    public static void main(String[] args) {
//        TVset sony = new Sony("Sony100H");
        RemoteControl stRemote = new StandardRemoteC(new Sony("Sony100H"));
        
        System.out.println(stRemote.tvSet.getName());
        stRemote.on();
        stRemote.setChannel(1);
        stRemote.off();
    }
}
