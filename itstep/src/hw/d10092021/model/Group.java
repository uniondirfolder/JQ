package hw.d10092021.model;

import hw.d10092021.sql.types.*;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.sql.enums.DB;


@Table(name = "category", dbType = DB.SQLITE)
public class Group {

    @SQLInteger(name = "INTEGER")
    @PrimaryKey
    @Constrains(allowNull = false)
    private long id;

    @SQLString(value = 50, name = "TEXT")
    @Constrains(allowNull = false ,unique = true)
    private String name;

    @SQLInteger(name = "INTEGER")
    @ForeignKey(innerColumn = "tasks", outerColumn = "group_id")
    private long relation;

    public Group(long id, String name, long group_id) throws NoSuchFieldException, SQLExceptionFieldLength {
        this.id = id;
        int i = this.getClass().getDeclaredField("name").getAnnotation(SQLString.class).value();
        if (name.length() > i) {
            throw new SQLExceptionFieldLength(i, name.length());
        }
        this.name = name;
        this.relation = group_id;
    }

    public Group(String name) {
        this.name = name;
    }
    public Group() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getRelation() {
        return relation;
    }
}
