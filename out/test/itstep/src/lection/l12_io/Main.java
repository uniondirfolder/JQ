package lection.l12_io;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Stream I/O
        //объект из которого можно считывать данные, называется называется потоком ввода(in)
        //объект в который можно записывать данные, называется называется потоком вывода(out)
//        System.out.println("Hello World");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextLine());

//        InputStream inputStream;
//        OutputStream outputStream;
//        Reader reader;
//        Writer writer;

//        File dir = new File("F:/files");
//        if (dir.mkdir()) {
//            System.out.println("папка создалась");
//        } else {
//            System.out.println("папка не создалась");
//        }
//        System.out.println(dir.isDirectory());
//
//        File txt = new File(dir, "test.txt");
//        try {
//            if (txt.createNewFile()) {
//                System.out.println("файл создался");
//            } else {
//                System.out.println("файл не создался");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String message = "w";
//        byte[] bytes = message.getBytes();
//        System.out.println(Arrays.toString(bytes));

        String message = "ю";
        byte[] bytes = message.getBytes();
        System.out.println(Arrays.toString(bytes));

        System.out.println(Byte.toUnsignedInt((byte) -47));
        System.out.println(Byte.toUnsignedInt((byte) -114));

    }
}
