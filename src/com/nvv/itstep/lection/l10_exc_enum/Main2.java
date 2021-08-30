package com.nvv.itstep.lection.l10_exc_enum;

import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        //throw new SQLException("такого запроса не существует");
        throw new ArithmeticException();
        //throw new IndexOutOfBoundsException("такого индекса не существует");
    }
}
