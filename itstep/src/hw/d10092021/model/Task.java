package hw.d10092021.model;


import hw.d10092021.sql.exeptions.SQLExceptionForeignKey;
import hw.d10092021.sql.types.*;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.sql.enums.DB;

import java.util.Date;

@Table(name = "tasks", dbType = DB.SQLITE)
public class Task {

    @SQLInteger(name = "INTEGER")
    private final long createdDate;

    @SQLString(150)
    private String description;

    @SQLInteger(name = "INTEGER")
    @ForeignKey(outerTable = "category", outerColumn = "id", innerColumn = "group_id")
    private final long group_id;

    public Task(long createdDate, long group_id) {
        this.createdDate = createdDate;
        this.group_id = group_id;
    }


    public Task(long createdDate, String description, long group_id) throws SQLExceptionFieldLength, NoSuchFieldException, SQLExceptionForeignKey {
        this.createdDate = createdDate;
        this.group_id = group_id;
        this.description = description;
        checkAnnotations(description);
    }

    public Task(String description, Date date, long group_id) throws SQLExceptionFieldLength, NoSuchFieldException, SQLExceptionForeignKey {
        this.group_id = group_id;
        this.createdDate = date.getTime();
        this.description = description;
        checkAnnotations(description);
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public long getGroup_id() {
        return group_id;
    }

    private void checkAnnotations(String description) throws NoSuchFieldException, SQLExceptionFieldLength, SQLExceptionForeignKey {
        int i = this.getClass().getDeclaredField("description").getAnnotation(SQLString.class).value();
        if (description.length() > i) {
            throw new SQLExceptionFieldLength(i, description.length());
        }
        String str = this.getClass().getDeclaredField("group_id").getAnnotation(ForeignKey.class).innerColumn();
        if (!str.equals("group_id")) {
            throw new SQLExceptionForeignKey("group_id", str);
        }
    }
}
