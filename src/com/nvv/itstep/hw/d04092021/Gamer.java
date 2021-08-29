package com.nvv.itstep.hw.d04092021;

import java.util.Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.Scanner;

public class Gamer implements Serializable {

    private String name;
    private int rightAnswers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Gamer(String name, int rightAnswers) {
        this.name = name;
        this.rightAnswers = rightAnswers;
    }


    @UseFileManager
    public Gamer(String[] args) throws FileManagerException {
        if (args == null || args.length != 2) {
            throw new FileManagerException("Invalid arguments.");
        }
        this.name = args[0];
        this.rightAnswers = Integer.parseInt(args[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return rightAnswers == gamer.rightAnswers && name.equals(gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rightAnswers);
    }

    public static ArrayList<Gamer> readCSV(String file) {

        try {
            Class gamerClass = Gamer.class;
            Field[] fields = gamerClass.getDeclaredFields();
            Annotation[] annotations = gamerClass.getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                if (!(annotations[i] instanceof Developer) || !(annotations[i] instanceof UseFileManager)) {
                    throw new FileManagerException("Not found constructor.");
                }
            }
            ArrayList<Gamer> arrayList = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File(file))) {
                int count = 0;
                while (scanner.hasNextLine()) {
                    String[] strings = scanner.nextLine().split(";");
                    if (strings.length != fields.length) {
                        throw new FileManagerException("Invalid file format.");
                    }
                    arrayList.add(new Gamer(strings));
                }
            }
            return arrayList;

        } catch (FileNotFoundException | FileManagerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Gamer readSingleRecordCSV(String file) {
        ArrayList<Gamer> gamers = readCSV(file);
        if (gamers.size() > 1) {
            try {
                throw new FileManagerException("More then one records found.");
            } catch (FileManagerException e) {
                e.printStackTrace();
            }
        }
        return gamers.get(0);
    }
}

