//package com.nvv.itstep.lection.io;
//
//import com.google.gson.Gson;
//
//public class Main5 {
//    public static void main(String[] args) {
//        User user = new User("Ivan", "066-555-33-33");
//        System.out.println(user.toString());
//
//        Gson gson = new Gson();
//        String jsonUser = gson.toJson(user);
//        System.out.println(jsonUser);
//
//        user  = null;
//        user = gson.fromJson(jsonUser, User.class);
//        System.out.println(user.getName());
//        System.out.println(User.class);
//    }
//}
