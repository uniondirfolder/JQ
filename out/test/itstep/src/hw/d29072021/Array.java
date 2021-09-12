package hw.d29072021;

import java.util.Iterator;
@Developer
public class Array<T> implements MyList<T> {
    private Object[] array = new Object[100];
    private int count = 0;


    @Override
    public int size() {
        if(array == null) return -1;
        return array.length;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void add(T item) {
        array[count] = item;
        count++;
    }

    @Override
    public void add(int index, T item) {
        if (freeCell() == 0) {
            resize(array.length + 1);
        }
        int i = count + 1;
        while (i > index) {
            array[i] = array[i - 1];
            i--;
        }
        array[index] = item;
        count++;
    }

    @Override
    public void remove(int index) {
        int i = index;
        while (i < count) {
            array[i] = array[i + 1];
            i++;
        }
        array[count] = null;
        count--;
    }

    @Override
    public void removeAll() {
        int i = 0;
        while (i < array.length) {
            array[i] = null;
            i++;
        }
    }

    @Override
    public void clear() {
        removeAll();
        this.array = null;
    }

    @Override
    public void resize(int value) {
        Object[] newArr = new Object[value];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        this.array = newArr;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int freeCell() {
        return array.length - count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contain(T that) {
        for (T item : this) {
            if (item.equals(that)) return true;
        }
        return false;
    }

    @Override
    public MyList<T> contains(MyList<T> list) {
        MyList<T> result = new Array<>();
        for (T item : list) {
            if (contain(item)) {
                result.add(item);
            }
        }
        return result;
    }


    @Override
    public Iterator iterator() {
        return new ArrayIterator<T>(); //Arrays.stream(this.array).iterator();
    }

    public class ArrayIterator<T> implements Iterator<T> {
        int inCount = -1;

        @Override
        public boolean hasNext() {
            return inCount < count - 1;
        }

        @Override
        public T next() {
            inCount++;
            return (T) array[inCount];
        }

    }
}
