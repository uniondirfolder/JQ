package com.nvv.itstep.lection.l7_cf;

import com.nvv.itstep.lection.l7_cf.home.ArrayUser;
import com.nvv.itstep.lection.l7_cf.home.User;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main8 {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.hashCode());

        Set<Integer> set = new LinkedHashSet<>();
        set.add(150);
        set.add(1);
        set.add(1000);
        set.add(1000);
        set.add(500);

        System.out.println(set);

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
