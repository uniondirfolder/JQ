package hw.d10092021.sql.exeptions;

public class SQLExceptionFieldLength extends Exception{
    public SQLExceptionFieldLength(int declared, int toSet) {
        super("Unavailable set field : name. Max length = " + declared + ". Length to set = " + toSet);
    }

}
