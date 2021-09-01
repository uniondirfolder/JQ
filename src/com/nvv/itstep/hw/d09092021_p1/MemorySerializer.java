package com.nvv.itstep.hw.d09092021_p1;

import java.io.*;

public class MemorySerializer<T> {
    public T serialize(T classObj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(classObj);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        T copy = (T) objectInputStream.readObject();
        return copy;
    }
}
