package hw.d20072021.data.table;


import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.container.AbstractContainer;

@Developer
public final class TablesExternal extends AbstractContainer implements InterfaceExternalTables {


    @Override
    public void tableRefSave(Object[] nameAndRef) {
        add(nameAndRef);
    }
}
