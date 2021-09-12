package hw.d19072021.arch.place;



import hw.d19072021.arch.store.Buyer;
import hw.d19072021.arch.store.Sailor;
import hw.d19072021.data.Repository;
import hw.d19072021.data.capsula.Category;
import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;

import java.util.Scanner;

@Developer
public final class Trade implements InterfaceTrade {
    private int countBuyers = 1;
    private int countSailors = 1;
    private Object[] buyers = new Object[1];
    private Object[] sailors = new Object[1];
    private Repository repository = new Repository();
    private Catalog catalog = new Catalog();

    public Trade() {
        repository.externalTables.tableRefSave(new Object[]{"buyers", buyers});
        repository.externalTables.tableRefSave(new Object[]{"sailors", sailors});
        catalog.container.init(catalog);
    }

    @Override
    public void tradeAddBuyer(String name, int age, String firstSnapshot) {
        Buyer buyer = Buyer.Builder(name, age, firstSnapshot);
        repository.users.add(buyer);
        repository.baskets.add(buyer.getBasket());
        arrayHelper(buyer, 0);
    }

    @Override
    public void tradeAddSailor(String name, int age, String firstSnapshot) {
        // TODO must end build logic
        Sailor sailor = new Sailor();
        repository.users.add(sailor);
        repository.products.add(sailor.goodsGet());
        arrayHelper(sailor, 1);
    }

    @Override
    public void tradeAddCatalogProduct(String productName, float price, String description, String categoryName) {
        Category category = new Category(categoryName);

        if (repository.category.categoryAdd(category)) {
            repository.category.add(category);
            catalog.container.add(category);
            System.out.println("Q");
        } else {
            category = repository.category.categoryGetRef(category);
        }
        ProductUnit productUnit = new ProductUnit(productName, price, description, category);
        repository.products.add(productUnit);
        catalog.container.addChild(productUnit);

    }

    private void arrayHelper(Object object, int whatArray) {
        if (0 == whatArray) {
            Object[] tmp = new Object[++countBuyers];
            int i = 0;
            while (buyers[i] != null) {
                tmp[i] = buyers[i];
                ++i;
            }
            tmp[buyers.length] = object;
            buyers = tmp;
        } else {
            Object[] tmp = new Object[++countSailors];
            int i = 0;
            while (sailors[i] != null) {
                tmp[i] = sailors[i];
                ++i;
            }
            tmp[sailors.length] = object;
            sailors = tmp;
        }
    }

    public void run(Trade t) {
        ProductUnit productUnit = null;
        t.tradeAddBuyer("Leonardo", 25, "( - , - )");
        Buyer buyer = (Buyer) t.buyers[countBuyers - 1];

        System.out.println("AddBuyer");
        t.tradeAddCatalogProduct("Milk", 50f, "FreshMilk", "Food");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("A-Tech 16GB", 60f, "A-Tech 16GB 2x 8GB PC3-12800 Desktop DDR3 1600 MHz 240pin DIMM Memory RAM 16G 8G", "Memory(RAM)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("Intel SR1QK", 65f, "Intel SR1QK Processor i5-4460, 3.20 GHz, Cores: 4", "Computer Processors (CPUs)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("EVGA GeForce GTX 1060", 1300f, "EVGA GeForce GTX 1060 6GB GDDR5 Video Card (06G-P4-6163-KR)", "Computer Graphics Cards");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("Team T-FORCE VULCAN Z 2x8GB", 55f, "Team T-FORCE VULCAN Z 2x8GB 16gb 288-Pin DDR4 SDRAM DDR4 3000 Intel XMP 2.0", "Memory(RAM)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("Atermiter", 26f, "Atermiter DDR4 4GB 8GB 16GB for intel Memory memoria ram 3000 RGB Desktop Dimm", "Memory(RAM)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("AMD Phenom II X6 1090T", 75f, "AMD Phenom II X6 1090T 3.2 GHz Six Core HDT90ZFBK6DGR Processor", "Computer Processors (CPUs)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("Ryzen 5 3600 6Core", 240f, "[AMD] Ryzen 5 3600 6Core 12Thread 7nm 3.6GHz PCIe4.0 65W CPU Processor!!", "Computer Processors (CPUs)");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("ZOTAC GeForce GTX 1660", 285f, "ZOTAC GeForce GTX 1660 Gaming TWIN Fan Graphics Card", "Computer Graphics Cards");
        System.out.println("AddProduct");
        t.tradeAddCatalogProduct("ASUS GeForce STRIX GTX 1060 ", 73f, "ASUS GeForce STRIX GTX 1060 DC2 Gaming OC 6GB Graphics Card", "Computer Graphics Cards");


//        System.out.println(buyer.historyGetCurrent());
//        catalog.printCategoryProducts(4, buyer);
//        System.out.println(buyer.historyGetCurrent());
//        catalog.printProductDescription(4, buyer);
//        System.out.println(buyer.historyGetCurrent());
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        int level = 0;
        catalog.printCategory(buyer);
        System.out.println(buyer.historyGetCurrent());
        System.out.println("0.Exit");

        while (run == true) {

            ch = sc.nextInt();

            if (ch == 0) {
                run = false;
            } else if (ch == 101) {
                level = 0;
                System.out.println(buyer.historyGetPrevious());
                System.out.println("0.Exit | 101. Previous | 303. Home");

            } else if (ch == 202) {
                level++;
                catalog.printBasket(buyer);
                System.out.println(buyer.historyGetCurrent());
                System.out.println("0.Exit | 101. Continue");
            } else if (ch == 303) {
                level = 0;
                catalog.printCategory(buyer);
                System.out.println(buyer.historyGetCurrent());
                System.out.println("0.Exit");
            } else if (ch<100 && ch > 0 && level == 0) {
                level++;
                catalog.printCategoryProducts(ch, buyer);
                System.out.println(buyer.historyGetCurrent());
                System.out.println("0.Exit | 101. Previous");
            } else if (ch<100 && ch > 0 && level == 1) {
                level++;
                catalog.printProductDescription(ch, buyer);
                System.out.println(buyer.historyGetCurrent());
                System.out.println("0.Exit | 101. Previous | 202. ToBasket");
            }

        }
    }
}
