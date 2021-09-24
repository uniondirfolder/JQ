package annotation.be;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {

        String[] str = new String[]{"annotation.be.Member"};
        if (str.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : str) {
            Class<?> cl = Class.forName(className);
            DbTable dbTable = cl.getAnnotation(DbTable.class);
            if (dbTable == null) {
                System.out.println("No DbTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                // если имя не указано, использовать имя Class
                tableName = cl.getName().toUpperCase(Locale.ROOT);
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = (Annotation[]) field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue; // не является столбцом таблицы базы данных
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // использовать имя поля, если имя не указано
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstrains(sInt.constrains()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // использовать имя поля, если имя не указано
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstrains(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder(
                        "CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n    " + columnDef + ",");
                }
                // удалить лишнию запитую
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstrains(Constrains constrains) {
        String con = "";
        if (!constrains.allowNull()) {
            con += " NOT NULL";
        }
        if (constrains.primaryKey()) {
            con += " PRIMARY KEY";
        }
        if (constrains.unique()) {
            con += " UNIQUE";
        }
        return con;
    }


}
