package hw.d06092021_p2.GoF.behavioral.Command;

public class InsertCommand implements Command {
    DatabaseReceiver database;

    public InsertCommand(DatabaseReceiver database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}
