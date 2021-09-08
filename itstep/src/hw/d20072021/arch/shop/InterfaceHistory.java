package hw.d20072021.arch.shop;

public interface InterfaceHistory {
     String historyGetNext();
     String historyGetPrevious();
     String historyGetCurrent();
     void historySetSnapshot(String snapshot);
}
