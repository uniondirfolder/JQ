package itstep.hw.d20072021.data.table;


import itstep.hw.d20072021.data.capsula.Category;
import itstep.hw.d20072021.data.capsula.Developer;

@Developer
public interface InterfaceCategory {
    public Category categoryGet(int index);
    public Category categoryGetRef(Category category);
    public Category[] categoryGetAll();
    public boolean isCategoryUnique(Category category);
    public boolean categoryAdd(Category category);

}
