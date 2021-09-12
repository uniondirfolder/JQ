package hw.d10092021.model;


import hw.d10092021.sql.exeptions.SQLExceptionForeignKey;
import hw.d10092021.sql.types.*;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.sql.enums.DB;
import hw.d10092021.view.model.VTask;

import java.util.Date;

@Table(name = "tasks", dbType = DB.SQLITE)
public class Task {

    @SQLInteger(name = "INTEGER")
    @PrimaryKey
    @Constrains(allowNull = false)
    private long id;

    @SQLInteger(name = "INTEGER")
    private final long createdDate;

    @SQLString(150)
    private String description;

    @SQLInteger(name = "INTEGER")
    @ForeignKey(outerTable = "category", outerColumn = "id", innerColumn = "group_id")
    private final long group_id;


    public Task(long id, long createdDate, String description, long group_id) throws SQLExceptionFieldLength, NoSuchFieldException, SQLExceptionForeignKey {
        this.id = id;
        this.createdDate = createdDate;
        this.group_id = group_id;
        this.description = description;
        checkAnnotations(description);
    }

    public Task(Task that) {
        this.id = that.id;
        this.group_id = that.group_id;
        this.createdDate = that.createdDate;
        this.description = that.description;
    }

    public Task(VTask that) {
        this.id = that.getId();
        this.group_id = that.getCategory_id();
        this.createdDate = that.getDate().getTime();
        this.description = that.getDescription();
    }

    public Task() {
        this.group_id = 0;
        this.createdDate = 0;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public long getGroup_id() {
        return group_id;
    }

    public long getId() {
        return id;
    }

    private void checkAnnotations(String description) throws NoSuchFieldException, SQLExceptionFieldLength, SQLExceptionForeignKey {
        if (description != null) {
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
}
