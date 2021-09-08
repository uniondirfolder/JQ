package itstep.hw.d20072021.arch.place;


import itstep.hw.d20072021.arch.store.Buyer;
import itstep.hw.d20072021.data.capsula.Developer;

@Developer
public interface CatalogPrint {
     void printCategory(Buyer buyer);
     void printCategoryProducts(int position, Buyer buyer);
     void printProductDescription(int position, Buyer buyer);
     void printBasket(Buyer buyer);
}
