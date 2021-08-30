package com.nvv.itstep.hw.d19072021.data.table;


import com.nvv.itstep.hw.d19072021.data.capsula.Category;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.container.AbstractContainer;

@Developer
public final class ItemsCategory extends AbstractContainer implements InterfaceCategory {

    private Category getCopy(Object obj) {
        if (obj != null) {
            Category tmp = (Category) obj;
            Category copy = new Category(tmp.getName());
            return copy;
        }
        return null;
    }

    @Override
    public Category categoryGet(int index) {
        Category category = getCopy(super.getRef(index));
        return category;
    }

    @Override
    public Category categoryGetRef(Category category) {
        int i = getCount();
        int j = 0;
        while (j < i) {
            Category tmp = (Category) super.getRef(j);
            if (!Category.isUniqueName(tmp, category)) return tmp;
            j++;
        }
        return null;
    }

    @Override
    public Category[] categoryGetAll() {
        int count = super.getCount();
        if (count == 0) return null;

        Category[] copyArray = new Category[count];
        int it = 0;
        while (it < count) {
            copyArray[it] = categoryGet(it);
            ++it;
        }
        return copyArray;
    }

    @Override
    public boolean isCategoryUnique(Category category) {
        int i = getCount();
        if (i > 0) {
            int j = 0;
            while (j < i) {
                Category tmp = (Category) super.getRef(j);
                if (Category.isUniqueName(tmp, category)) return true;
                ++j;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean categoryAdd(Category category) {
        int i = getCount();
        int f = 0;
        if (i > 0) {
            int j = 0;
            while (j < i) {
                Category tmp = (Category) super.getRef(j);
                if (!Category.isUniqueName(tmp, category)) {
                    f++;
                }
                ++j;
            }
        }
        if (f == 0) {
            add(category);
            return true;
        }
        return false;
    }


}
