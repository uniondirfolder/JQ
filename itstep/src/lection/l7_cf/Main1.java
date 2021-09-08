package lection.l7_cf;


import lection.l7_cf.home.User;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add(new User("Ivan"));
        list.add(3);
        list.add(5);
        double sum = 0;
        for (Object o : list) {
            if (o instanceof Integer) {
                sum += (Integer) o;
            }
            //System.out.println(o);
        }
        System.out.println(sum);
    }
}
