package hw.d20072021.arch.shop;


import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.capsula.Product;
import hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBasket {
     Customer basketGetCustomer();
     Product[] basketGetGoods();
     void basketAddGoods(ProductUnit productUnit);

}
