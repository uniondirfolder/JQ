package hw.d06092021_p2.GoF.behavioral.Command;

public class DeleteCommand implements Command {
    DatabaseReceiver database;

    public DeleteCommand(DatabaseReceiver database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}
