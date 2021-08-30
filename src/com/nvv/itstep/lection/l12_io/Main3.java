package com.nvv.itstep.lection.l12_io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main3 {
    public static void main(String[] args) {
//        PrintWriter printWriter = null;
//        try {
//            printWriter = new PrintWriter("./test2.txt");
//            printWriter.write("Hello");
//            printWriter.write("World");
//            printWriter.write("!");
//            printWriter.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (printWriter != null) {
//                printWriter.close();
//            }
//        }
        try (PrintWriter printWriter = new PrintWriter("./test2.txt")){
            printWriter.println("Hello");
            printWriter.println("World");
            printWriter.println("!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
