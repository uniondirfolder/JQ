package itstep.hw.d19072021.data;


import itstep.hw.d19072021.data.capsula.Developer;
import itstep.hw.d19072021.data.capsula.User;
import itstep.hw.d19072021.data.table.*;

@Developer
public final class Repository {
    private User user = new User("system",0);
    public TablesExternal externalTables = new TablesExternal();
    public ItemsBasket baskets = new ItemsBasket(user);
    public ItemsCategory category = new ItemsCategory();
    public ItemsProduct products = new ItemsProduct();
    public ItemsUser users = new ItemsUser();


}
