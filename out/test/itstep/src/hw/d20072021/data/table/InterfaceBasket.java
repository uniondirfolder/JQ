package hw.d20072021.data.table;


import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.capsula.ProductUnit;
import hw.d20072021.data.capsula.User;

@Developer
public interface InterfaceBasket {
    public User basketGetUser();
    public ProductUnit basketGetProduct(int position);
    public ProductUnit[] basketGetProductItems();

    public void basketAddProductItem(ProductUnit productUnit);
    public void basketRemoveProductItem(int position);
    public void basketRemoveProducts(int position);
}
