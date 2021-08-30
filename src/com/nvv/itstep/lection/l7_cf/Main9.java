package com.nvv.itstep.lection.l7_cf;
import com.nvv.itstep.lection.l7_cf.home.ArrayUser;
import com.nvv.itstep.lection.l7_cf.home.User;

import java.util.ArrayList;

public class Main9 {
    public static void main(String[] args) {
        User user1 = new User("Ivan", "Ivanov", 18);
        User user2 = new User("Ivan", "Ivanov", 18);
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());


    }
}
