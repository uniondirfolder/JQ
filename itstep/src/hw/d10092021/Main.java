package hw.d10092021;

import hw.d10092021.controller.Actions;
import hw.d10092021.view.Users;
import hw.d10092021.view.model.VTask;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Actions actions = new Actions("org.sqlite.JDBC", "jdbc:sqlite:C:\\REPO\\JQ\\temp\\main.db");
        Users users = new Users(actions);
        Scanner cs = new Scanner(System.in);
        String str = "";
        int level = 0;
        int index = 0;
        while (true) {
            users.showLevel(level, index);

            str = cs.nextLine();
            if (str.equals("-all")) {
                level = 4;
            } else if (str.equals("-main")) {
                level = 0;
            } else if (str.equals("-add")) {
                users.showGroup();
                System.out.println("add > category? n: ");
                str = cs.nextLine();
                try {
                    int cat = Integer.parseInt(str);
                    System.out.println("add > description? : ");
                    str = cs.nextLine();
                    users.buildTask(cat, new VTask(new Date().getTime(), str, cat));
                    level = 4;
                } catch (Exception e) {
                    System.out.println("bad params!");
                    level = 0;
                }

            } else if (str.equals("-edit")) {
                try {
                    System.out.println("edit > task? n: ");
                    str = cs.nextLine();
                    int cat = Integer.parseInt(str);
                    System.out.println("edit > description? : ");
                    str = cs.nextLine();
                    users.updateTask(cat, new VTask(new Date().getTime(), str, cat));
                    level = 4;
                } catch (Exception e) {
                    System.out.println("bad params!");
                    level = 0;
                }

            } else if (str.equals("-del")) {
                try {
                    System.out.println("del > task? n: ");
                    str = cs.nextLine();
                    int i = Integer.parseInt(str);
                    users.deleteTask(i);
                    level = 4;
                } catch (Exception e) {
                    System.out.println("bad params!");
                    level = 0;
                }

            } else if ("exit".equals(str)) {
                break;
            } else {
                try {
                    index = Integer.parseInt(str);
                    level++;
                } catch (Exception e) {
                    System.out.print("bad params!");
                    level = 0;
                }
            }
        }
    }
}
