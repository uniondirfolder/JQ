package com.nvv.implts;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Loggers {
    private String file;

    public Loggers(String file) {
        this.file = file;
    }

    public Loggers() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public void writeToFile(String log) {
        System.out.println("Logger work.");
        try (FileWriter f = new FileWriter(file, true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            p.println( sdf.format(new Date().getTime()) + " > " +log + " ;");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
