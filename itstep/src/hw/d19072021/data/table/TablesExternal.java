package hw.d19072021.data.table;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.container.AbstractContainer;

@Developer
public final class TablesExternal extends AbstractContainer implements InterfaceExternalTables {


    @Override
    public void tableRefSave(Object[] nameAndRef) {
        add(nameAndRef);
    }
}
