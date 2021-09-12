package lection.l7_cf;


import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add("Hello");
//        list.add(new User("Ivan"));
        list.add(3);
        list.add(5);
        double sum = 0;
        for (int o : list) {
                sum += o;

            //System.out.println(o);
        }
        System.out.println(sum);
    }
}
