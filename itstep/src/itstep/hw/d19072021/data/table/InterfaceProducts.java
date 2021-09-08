package itstep.hw.d19072021.data.table;


import itstep.hw.d19072021.data.capsula.Developer;
import itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceProducts {
     ProductUnit productGet(int index);

     ProductUnit[] userGetAll();
}
