package hw.d10092021.test;

import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.utils.DateCalculate;

import java.util.Calendar;
import java.util.Date;

import static hw.d10092021.utils.DateCalculate.*;

public class Test {
    public static void main(String[] args) throws SQLExceptionFieldLength, NoSuchFieldException {
//        Group gr = new Group(0,"XXX", 0);
//        Task tsk = null;
//        try {
//            tsk = new Task(1, new Date().getTime(),"XXX",1);
//        } catch (SQLExceptionForeignKey e) {
//            e.printStackTrace();
//        }
//        Commands cmds = new Commands();
//        String str ="";
//        str = cmds.create(DB.SQLITE,SQLite.TABLE,gr);
//        System.out.println(str);
//
//        str = cmds.create(DB.SQLITE,SQLite.RECORD,gr);
//        System.out.println(str);
//
//        str = cmds.update(DB.SQLITE,SQLite.RECORD,gr);
//        System.out.println(str);
//
//        str = cmds.delete(DB.SQLITE,SQLite.TABLE,gr);
//        System.out.println(str);
//
//        str = cmds.delete(DB.SQLITE,SQLite.RECORD,gr);
//        System.out.println(str);
//
//        System.out.println("*".repeat(15));
//        str = cmds.read(DB.SQLITE,SQLite.TABLE,gr);
//        System.out.println(str);
//        str = cmds.read(DB.SQLITE,SQLite.RECORD,tsk);
//        System.out.println(str);
//
//        System.out.println("*".repeat(15));
//        str = cmds.update(DB.SQLITE,SQLite.RECORD,tsk);
//        System.out.println(str);
//
//        Actions actions = new Actions("org.sqlite.JDBC", "jdbc:sqlite:C:\\REPO\\JQ\\temp\\main.db");
//        Users users = new Users(actions);

        // users.updateTask(new VTask(1, new Date().getTime(), "UPDATE1",1));
        // users.updateTask(new VTask(2, new Date().getTime(), "UPDATE2",1));
        // users.deleteTask(2);
        long v1 = getMillisByPattern("h:mm");
        long v2 = getMillisByPattern("EEE");
        long v3 = getMillisByPattern("MMM");
        long v4 = getMillisByPattern("h:mm:ss");
        long v5 = getMillisByPattern("d");
        long v6 = new Date().getTime()-(new Date().getTime()- DateCalculate.getMillisByPattern("yyyy.MM.dd")); //
        long v7 = new Date().getTime();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        System.out.println(getViewByPattern("h:mm",v1));
        System.out.println(getViewByPattern("EEE",v2));
        System.out.println(getViewByPattern("MMM",v3));
        System.out.println(getViewByPattern("h:mm:ss",v4));
        System.out.println(getViewByPattern("d",v5));
        System.out.println(v6);
        System.out.println(v7);
        System.out.println(v7>v6);
        System.out.println(new Date(v6));
//        int i = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//        int i1 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        int i2 = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
//        int i3 = Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
//        System.out.println(i);
//        System.out.println(i1);
//        System.out.println(i2);
//        System.out.println(i3);


    }
}
