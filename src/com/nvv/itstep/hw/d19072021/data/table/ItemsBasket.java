package com.nvv.itstep.hw.d19072021.data.table;


import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;
import com.nvv.itstep.hw.d19072021.data.capsula.User;
import com.nvv.itstep.hw.d19072021.data.container.AbstractContainer;

@Developer
public final class ItemsBasket extends AbstractContainer implements InterfaceBasket {
    private User user;

    public ItemsBasket(User user) {
        this.user = user;
    }

    private ProductUnit getCopy(Object obj) {
        if (obj != null) {
            ProductUnit tmp = (ProductUnit) obj;
            ProductUnit copy = new ProductUnit(tmp.getName(), tmp.getPrice(),tmp.getDescription(),tmp.getCategory());
            return copy;
        }
        return null;
    }


    @Override
    public User basketGetUser() {
        return user;
    }

    @Override
    public ProductUnit basketGetProduct(int index) {
        // ToDo implement
        return null;
    }

    @Override
    public ProductUnit[] basketGetProductItems() {
        int count = super.getCount();
        if (count == 0) return null;

        ProductUnit[] copyArray = new ProductUnit[count];
        int it = 0;
        while (it < count) {
            copyArray[it] = basketGetProduct(it);
            ++it;
        }
        return copyArray;
    }

    @Override
    public void basketAddProductItem(ProductUnit productUnit) {
        // ToDo implement
    }

    @Override
    public void basketRemoveProductItem(int index) {
        // ToDo implement
    }

    @Override
    public void basketRemoveProducts(int index) {
        // ToDo implement
    }
}
