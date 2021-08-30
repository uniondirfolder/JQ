package com.nvv.itstep.lection.l7_cf;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(111);
        integers.add(222);
        integers.add(333);
        integers.add(444);
        integers.add(555);
        integers.add(666);
        integers.add(777);
        integers.add(888);
        integers.add(999);
        integers.add(1000);
        integers.add(11);
        integers.add(11);
        integers.add(11);
        integers.add(11);
        integers.add(11);
        integers.add(16);
        System.out.println(integers.size());

        try {
            System.out.println(getCapacity(integers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}
