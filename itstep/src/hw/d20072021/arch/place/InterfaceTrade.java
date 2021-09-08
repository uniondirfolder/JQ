package hw.d20072021.arch.place;

import hw.d20072021.data.capsula.Developer;

@Developer
public interface InterfaceTrade {
     void tradeAddBuyer(String name, int age, String firstSnapshot);
     void tradeAddSailor(String name, int age, String firstSnapshot);
     void tradeAddCatalogProduct(String productName, float price, String description, String categoryName);
}
