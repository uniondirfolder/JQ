package hw.d10092021.sql.enums;

public enum SQLite {
    ABORT("ABORT "),
    ASC("ASC "),
    AUTOINCREMENT("AUTOINCREMENT "),
    BLOB("BLOB "),
    CASCADE("CASCADE "),
    CREATE("CREATE "),
    DELETE("DELETE "),
    DESC("DESC "),
    FAIL("FAIL "),
    FOREIGN_KEY("FOREIGN KEY "),
    IGNORE("IGNORE "),
    INSERT_INTO("INSERT INTO "),
    INTEGER("INTEGER "),
    NOT_NULL("NOT NULL "),
    NO_ACTION("NO ACTION "),
    NULL("NULL "),
    NUMERIC("NUMERIC "),
    PRIMARY_KEY("PRIMARY KEY "),
    READ("READ "),
    REAL("REAL "),
    RECORD("RECORD "),
    REPLACE("REPLACE "),
    RESTRICT("RESTRICT "),
    ROLLBACK("ROLLBACK "),
    SET_DEFAULT("SET DEFAULT "),
    SET_NULL("SET NULL "),
    TABLE("TABLE "),
    TEXT("TEXT "),
    UNIQUE("UNIQUE "),
    UPDATE("UPDATE "),
    VALUES("VALUES "),
    SELECT("SELECT "),
    FROM("FROM "),
    SET("SET "),
    WHERE("WHERE "),
    ID("ID "),
    DROP("DROP "),
    IF("IF "),
    NOT("NOT "),
    EXISTS("EXISTS ");


    private String value;

    public String getValue() {
        return value;
    }

    SQLite(String value) {
        this.value = value;
    }
}
