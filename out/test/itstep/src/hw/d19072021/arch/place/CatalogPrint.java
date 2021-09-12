package hw.d19072021.arch.place;


import hw.d19072021.arch.store.Buyer;
import hw.d19072021.data.capsula.Developer;

@Developer
public interface CatalogPrint {
    void printCategory(Buyer buyer);
    void printCategoryProducts(int position, Buyer buyer);
    void printProductDescription(int position, Buyer buyer);
    void printBasket(Buyer buyer);
}
