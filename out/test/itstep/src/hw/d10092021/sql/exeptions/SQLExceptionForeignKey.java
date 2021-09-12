package hw.d10092021.sql.exeptions;

public class SQLExceptionForeignKey extends Exception {
    public SQLExceptionForeignKey(String declared, String binding) {
        super("Unavailable set foreign key : " + declared + "/" + binding);
    }

}
