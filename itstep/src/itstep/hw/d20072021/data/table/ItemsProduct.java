package itstep.hw.d20072021.data.table;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.ProductUnit;
import itstep.hw.d20072021.data.container.AbstractContainer;
@Developer
public final class ItemsProduct  extends AbstractContainer implements InterfaceProducts {

    private ProductUnit getCopy(Object obj) {
        if (obj != null) {
            ProductUnit tmp = (ProductUnit) obj;
            ProductUnit copy = new ProductUnit(tmp.getName(), tmp.getPrice(),tmp.getDescription(),tmp.getCategory());
            return copy;
        }
        return null;
    }
    @Override
    public ProductUnit productGet(int index) {
        return getCopy(index);
    }

    @Override
    public ProductUnit[] userGetAll() {
        int count = super.getCount();
        if (count == 0) return null;

        ProductUnit[] copyArray = new ProductUnit[count];
        int it = 0;
        while (it < count) {
            copyArray[it] = productGet(it);
            ++it;
        }
        return copyArray;
    }
}
