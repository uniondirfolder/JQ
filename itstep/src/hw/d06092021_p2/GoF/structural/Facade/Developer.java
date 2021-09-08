package hw.d06092021_p2.GoF.structural.Facade;

public class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker) {
        if(bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problem...");
        } else {
            System.out.println("Developer read shpora...");
        }
    }
}
