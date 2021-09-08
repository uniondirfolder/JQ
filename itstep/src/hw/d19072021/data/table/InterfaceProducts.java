package hw.d19072021.data.table;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceProducts {
     ProductUnit productGet(int index);

     ProductUnit[] userGetAll();
}
