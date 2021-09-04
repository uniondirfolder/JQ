package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Command;

public class DeveloperInvoker {
    Command insert;
    Command read;
    Command update;
    Command delete;

    public DeveloperInvoker(Command insert, Command read, Command update, Command delete) {
        this.insert = insert;
        this.read = read;
        this.update = update;
        this.delete = delete;
    }

    public void insertRecord() {
        insert.execute();
    }

    public void readRecord() {
        read.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }
}
