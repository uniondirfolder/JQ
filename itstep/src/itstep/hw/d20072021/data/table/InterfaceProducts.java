package itstep.hw.d20072021.data.table;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceProducts {
    public ProductUnit productGet(int index);

    public ProductUnit[] userGetAll();
}
