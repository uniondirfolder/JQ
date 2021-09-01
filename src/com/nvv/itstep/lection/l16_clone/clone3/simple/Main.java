package com.nvv.itstep.lection.l16_clone.clone3.simple;



import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //сереилизация и десереализация для копирования
        User original = new User("Ivan", 18);
        System.out.println(original);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(original);

       // System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        User copy = (User) objectInputStream.readObject();

        copy.setLogin("Petr");
        copy.setAge(33);

        System.out.println(original);

    }
}
