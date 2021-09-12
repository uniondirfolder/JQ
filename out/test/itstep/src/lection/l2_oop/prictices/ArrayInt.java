package lection.l2_oop.prictices;

public class ArrayInt {
    private int[] data;
    private int size;
    public ArrayInt() {
        data = new int[0];
        size = 0;
    }

    public void add(int value) {
        int[] temp = new int[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        temp[temp.length - 1] = value;
        data = temp;
        size++;
    }

    public int getSize() {
        return size;
    }
}
