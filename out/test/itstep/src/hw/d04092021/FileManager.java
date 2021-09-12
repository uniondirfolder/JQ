package hw.d04092021;

import java.io.*;


@Developer
public class FileManager<T> {

    public T readFileDeSerialize(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeFileSerialize(String file, T clazz) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(clazz);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
