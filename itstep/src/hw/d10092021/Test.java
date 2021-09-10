package hw.d10092021;

import hw.d10092021.model.Group;
import hw.d10092021.sql.enums.DB;
import hw.d10092021.sql.enums.SQLite;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.utils.Commands;

public class Test {
    public static void main(String[] args) throws SQLExceptionFieldLength, NoSuchFieldException {
        Group gr = new Group(0,"XXX", 0);
        Commands cmds = new Commands();
        String str ="";
        str = cmds.create(DB.SQLITE,SQLite.TABLE,gr);
        System.out.println(str);

        str = cmds.create(DB.SQLITE,SQLite.RECORD,gr);
        System.out.println(str);

        str = cmds.update(DB.SQLITE,SQLite.RECORD,gr);
        System.out.println(str);

        str = cmds.delete(DB.SQLITE,SQLite.TABLE,gr);
        System.out.println(str);

        str = cmds.delete(DB.SQLITE,SQLite.RECORD,gr);
        System.out.println(str);

        System.out.println("*".repeat(15));
        str = cmds.read(DB.SQLITE,SQLite.TABLE,gr);
        System.out.println(str);
        str = cmds.read(DB.SQLITE,SQLite.RECORD,gr);
        System.out.println(str);
    }
}
