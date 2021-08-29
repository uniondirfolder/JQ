package com.nvv.itstep.lection.io;

import java.io.*;

public class Main6 {
    public static void main(String[] args) {
//        User user = new User("Artem", "666");
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./user.dat"))) {
//            outputStream.writeObject(user);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./user.dat"))) {
            User user = (User) objectInputStream.readObject();
            System.out.println(user.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
