package itstep.hw.d19072021.arch.shop;

import itstep.hw.d19072021.data.capsula.Developer;

@Developer
public interface InterfaceHistory {
    String historyGetNext();
    String historyGetPrevious();
    String historyGetCurrent();
    void historySetSnapshot(String snapshot);
}
