package com.nvv.itstep.hw.d20072021.arch.place;

import com.nvv.itstep.hw.d20072021.arch.store.Buyer;
import com.nvv.itstep.hw.d20072021.data.capsula.Category;
import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;
import com.nvv.itstep.hw.d20072021.data.container.AbstractContainer;

@Developer
public class CatalogCursor extends AbstractContainer {
    class Position {
        public boolean isReturn = false;
        public int currentCategory = -1;
        public int currentProduct = -1;
        public boolean inBasket = false;
        public Command command = Command.DEFAULT;

        public Position() {
        }

        public Position(Position position) {
            this.isReturn = position.isReturn;
            this.currentCategory = position.currentCategory;
            this.currentProduct = position.currentProduct;
            this.inBasket = position.inBasket;
            this.command = position.command;
        }
    }

    private Position position = new Position();
    private Catalog catalog;


    public CatalogCursor(Catalog catalog) {
        this.catalog = catalog;
    }

    public CatalogCursor() {
        catalog = new Catalog();
    }

    public Position getPosition() {
        return this.position;
    }

    public String getView(Command command, int indexCategory, int indexProduct, Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        int countInBasket = 0;
        if (buyer.getBasket().basketGetGoods() != null) {
            countInBasket = buyer.getBasket().basketGetGoods().length;
        }

        switch (command) {
            case TO_CATEGORY -> {
                if (position.isReturn == false) {
                    position.command = Command.TO_CATEGORY;
                    fixPosition();
                } else {
                    position.isReturn = false;
                }
                Object[] tmp = catalog.container.getParents();
                sb.append("**********\nКатегории: \n");
                Category cat;
                for (int i = 1; i < tmp.length; i++) {
                    sb.append(i + ". ");
                    cat = (Category) tmp[i];
                    sb.append(cat.getName() + '\n');
                }
                sb.append("0. Выход /  (1...)- № категории / 102. Корзина = " + countInBasket + " ед. товара");

            }
            case TO_LIST_PRODUCT -> {
                if (position.isReturn == false) {
                    position.command = Command.TO_LIST_PRODUCT;
                    position.currentCategory = indexCategory;
                    fixPosition();
                } else {
                    position.isReturn = false;
                }
                Category cat = (Category) catalog.container.getParentRef(indexCategory);
                Object[] tmp = catalog.container.getChildren();
                sb.append("**********\nКатегория: " + cat.getName() + "\nТовары: \n");
                for (int i = 1; i < tmp.length; i++) {
                    ProductUnit pu = (ProductUnit) tmp[i];
                    if (pu.getCategory().equals(cat)) {
                        sb.append(i + ". ");
                        sb.append(pu.getName() + " $ " + pu.getPrice() + '\n');
                    }
                }
                sb.append("0. Выход / 103. Вернуться / № товара - к описанию / 102. Корзина = " + countInBasket + " ед. товара");

            }
            case TO_DESCRIPTION -> {
                if (position.isReturn == false) {
                    position.command = Command.TO_DESCRIPTION;
                    position.currentProduct = indexProduct;
                    fixPosition();
                } else {
                    position.isReturn = false;
                }
                Category cat = (Category) catalog.container.getParentRef(position.currentCategory);
                Object[] tmp = catalog.container.getChildren();
                ProductUnit pu = (ProductUnit) tmp[position.currentProduct + 1];
                sb.append("**********\nКатегория: " + cat.getName() + "\nТовар:" + pu.getName() + "\n");
                sb.append("Описание: " + pu.getDescription() + "\n");
                sb.append("0. Выход / 103. Вернуться / 104. Добавить в корзину / 102. Корзина = " + countInBasket + " ед. товара");

            }
            case TO_BASKET -> {
                if (position.isReturn == false) {
                    position.command = Command.TO_BASKET;
                    fixPosition();
                } else {
                    position.isReturn = false;
                }
                sb.append("Корзина: \n");
                ProductUnit[] pu = buyer.getBasket().basketGetGoods();
                if (countInBasket == 0) {
                    sb.append("Корзина пуста...\n");
                } else {
                    float sum = 0;
                    for (int i = 0; i < pu.length; i++) {
                        sb.append(i +". "+ pu[i].toString()+'\n');
                        sum += pu[i].getPrice();
                    }
                    sb.append("\nСумма: " + sum + " $\n");
                }
                sb.append("0. Выход / 101. Продолжить покупки\n");

            }
            case RETURN -> {
                System.out.println(getCount());
                if (this.getCount() > 2) {
                    this.deleteLast();
                    position = new Position((Position) getLastRef());
                    position.isReturn = true;
                    sb.append(getView(position.command, position.currentCategory, position.currentProduct, buyer));
                } else {
                    this.deleteLast();
                    sb.append(getView(Command.TO_CATEGORY, 0, 0, buyer));
                }
            }
            case AD_TO_BASKET -> {
                sb.append("Товар добавлен в корзину\n");
                Object[] tmp = catalog.container.getChildren();
                ProductUnit pu = (ProductUnit) tmp[position.currentProduct + 1];
                buyer.basketAdd(pu);
                sb.append(getView(Command.TO_CATEGORY, 0, 0, buyer));
            }
        }
        return sb.toString();
    }

    private void fixPosition() {
        Position p = new Position(position);
        add(p);
    }
}
