package hw.d06092021_p2.GoF.behavioral.Chain;

public class SMSNotifier extends Notifier {

    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending SMS to manager: " + message);
    }
}
