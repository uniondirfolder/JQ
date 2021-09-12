package hw.d20072021.arch.shop;


import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.container.AbstractContainer;
@Developer
public class History extends AbstractContainer implements InterfaceHistory {
    private int cursor = 0;

    public History(String firstSnapshot) {
        super();
        historySetSnapshot(firstSnapshot);
    }
    private boolean checkIncrement(){
        if(getCount() == 0) return false;
        return true;
    }
    @Override
    public String historyGetNext() {
        if(cursor == getCount() - 1) {
            cursor = 1;
        }
        else if(checkIncrement() == true) cursor++;
        return (String) getRef(cursor);
    }

    @Override
    public String historyGetPrevious() {
        if(cursor == 1) {
            cursor = getCount() - 1;
        }
        else if(checkIncrement() == true) cursor--;
        return (String) getRef(cursor);
    }

    @Override
    public String historyGetCurrent() {
        return  (String) getRef(cursor-1);
    }

    @Override
    public void historySetSnapshot(String snapshot) {
        add(snapshot);
        cursor++;
    }
}
