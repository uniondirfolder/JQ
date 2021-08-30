package com.nvv.itstep.hw.d19072021.arch.place;


import com.nvv.itstep.hw.d19072021.arch.shop.Basket;
import com.nvv.itstep.hw.d19072021.arch.store.Buyer;
import com.nvv.itstep.hw.d19072021.data.capsula.Category;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;
import com.nvv.itstep.hw.d19072021.data.container.Container;

@Developer
public final class Catalog implements CatalogPrint {
    public Container container = new Container();


    @Override
    public void printCategory(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        Object[] tmp = container.getParents();
        sb.append("Category: \n");
        Category cat;
        for (int i = 1; i < tmp.length; i++) {
            sb.append(i + ". ");
            cat = (Category) tmp[i];
            sb.append(cat.getName() + '\n');
        }
        buyer.historySetSnapshot(sb.toString());
    }

    @Override
    public void printCategoryProducts(int position, Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        Category cat = (Category) container.getParentRef(--position);
        Object[] tmp = container.getChildren();
        sb.append("Products: \n");
        for (int i = 1; i < tmp.length; i++) {
            ProductUnit pu = (ProductUnit) tmp[i];
            if (pu.getCategory().equals(cat)) {
                sb.append(i+". ");
                sb.append(pu.getName() + " $ " + pu.getPrice() +'\n');
            }
        }
        buyer.historySetSnapshot(sb.toString());
    }

    @Override
    public void printProductDescription(int position, Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket: \n");
        Basket basket = buyer.getBasket();
        Object[] tmp = container.getChildren();
        ProductUnit pu = (ProductUnit) tmp[position];
        sb.append(pu.getDescription());
        buyer.historySetSnapshot(sb.toString());
        buyer.getBasket().setCurrentView(pu);
        buyer.basketAdd(buyer.getBasket().getCurrentView());
    }

    @Override
    public void printBasket(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket: \n");
        ProductUnit[] pu = buyer.getBasket().basketGetGoods();
        for (int i = 0; i < pu.length; i++) {
            sb.append(pu[i].toString());
        }
        sb.append('\n');
        buyer.historySetSnapshot(sb.toString());

    }
}
