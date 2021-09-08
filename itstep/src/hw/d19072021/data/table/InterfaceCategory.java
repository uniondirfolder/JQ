package hw.d19072021.data.table;


import hw.d19072021.data.capsula.Category;
import hw.d19072021.data.capsula.Developer;

@Developer
public interface InterfaceCategory {
     Category categoryGet(int index);
     Category categoryGetRef(Category category);
     Category[] categoryGetAll();
     boolean isCategoryUnique(Category category);
     boolean categoryAdd(Category category);

}
