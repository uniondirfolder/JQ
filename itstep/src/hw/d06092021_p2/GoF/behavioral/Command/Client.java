package hw.d06092021_p2.GoF.behavioral.Command;

public class Client {
    public static void main(String[] args) {
        DatabaseReceiver database = new DatabaseReceiver();

        DeveloperInvoker developer = new DeveloperInvoker(
                new InsertCommand(database),
                new ReadCommand(database),
                new UpdateCommand(database),
                new DeleteCommand(database));

        developer.insertRecord();
        developer.readRecord();
        developer.updateRecord();
        developer.deleteRecord();
    }
}
