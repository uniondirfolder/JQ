package hw.d06092021_p2.GoF.behavioral.Chain;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("EveryThing is OK.", Priority.ROUTINE);
        reportNotifier.notifyManager("Something went wrong!", Priority.IMPORTANT);
        reportNotifier.notifyManager("Houston, we've had a problem here!!!", Priority.ASAP);
//        emailNotifier.notifyManager("Something went wrong!", Priority.IMPORTANT);
//        smsNotifier.notifyManager("Houston, we've had a problem here!!!", Priority.ASAP);
    }
}
