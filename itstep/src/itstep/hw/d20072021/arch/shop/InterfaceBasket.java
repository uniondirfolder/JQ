package itstep.hw.d20072021.arch.shop;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.Product;
import itstep.hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBasket {
     Customer basketGetCustomer();
     Product[] basketGetGoods();
     void basketAddGoods(ProductUnit productUnit);

}
