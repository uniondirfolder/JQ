package itstep.hw.d29072021;

import java.util.Iterator;
@Developer
public interface MyList<T> extends Iterable<T> {
    int size();
    int count();
    void resize(int value);
    void add(T item);
    void add(int index, T item);
    void remove(int index);
    void removeAll();
    void clear();
    T get(int index);
    int freeCell();
    boolean isEmpty();
    boolean contain(T item);
    MyList<T> contains(MyList<T> item);


    @Override
    Iterator<T> iterator();
}
