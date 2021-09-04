package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Command;

public class ReadCommand implements Command {
    DatabaseReceiver database;

    public ReadCommand(DatabaseReceiver database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.read();
    }
}

