package hw.d20072021.data.table;


import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceProducts {
    public ProductUnit productGet(int index);

    public ProductUnit[] userGetAll();
}
