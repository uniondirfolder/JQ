package com.nvv.itstep.lection.l18_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/first_db";
        String user = "postgres";
        String password = "7410";
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts(first_name VARCHAR, last_name VARCHAR)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

//-- CREATE TABLE developer
//        -- (
//        -- 	id SERIAL PRIMARY KEY,
//        -- 	first_name VARCHAR(25),
//        -- 	second_name VARCHAR(25),
//        -- 	salary INTEGER CHECK(salary>0)
//        -- )
//
//        -- INSERT INTO developer(first_name, second_name, salary)VALUES('Ivan', 'Ivanov', 1000);
//
//        -- SELECT * FROM developer