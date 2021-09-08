package hw.d19072021.data.table;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;
import hw.d19072021.data.capsula.User;

@Developer
public interface InterfaceBasket {
     User basketGetUser();
     ProductUnit basketGetProduct(int position);
     ProductUnit[] basketGetProductItems();

     void basketAddProductItem(ProductUnit productUnit);
     void basketRemoveProductItem(int position);
     void basketRemoveProducts(int position);
}
