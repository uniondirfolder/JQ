package com.nvv.itstep.lection.l8_stream_api.ref;

public class Main {
    public static void main(String[] args) {
//        Checker<Integer> isPositive = v -> v > 0;
//        Checker<Integer> checker = CheckerHelper::isEven;
//        System.out.println(checker.check(5));
//
//        Checker<String>length = v -> v.length() > 6;
//        System.out.println(length.check("qwerty1"));
//
//        User user1 = new User("Ivan");
//        User user2 = new User("Petr");
//        UserUtil userUtil = user2::getFirstName;
//        System.out.println(userUtil.getData());


//        int i = Integer.parseInt("1");
//        execute(Integer::parseInt,"3");
    }

    public static void execute(Changer changer, String number) {
        int result = changer.change(number);
        System.out.println(result);
    }
}
