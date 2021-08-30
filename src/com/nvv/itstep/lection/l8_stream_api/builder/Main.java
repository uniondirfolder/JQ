package com.nvv.itstep.lection.l8_stream_api.builder;

public class Main {
    public static void main(String[] args) {
        //User user = new User();
//        User.Builder builder = new User.Builder();
//        builder.setFirstName("Ivan")
//                .setLastName("Ivanov")
//                .setPhone("777");
//        User user1 = builder.create();

        User user1 = new User.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .create();
        User user2 = new User.Builder()
                .setFirstName("Ivanov")
                .setPhone("777")
                .create();

        System.out.println(user1);
        System.out.println(user2);
    }
}
