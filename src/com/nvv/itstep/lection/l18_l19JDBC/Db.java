package com.nvv.itstep.lection.l18_l19JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Db {
    private final String URL = "jdbc:postgresql://localhost/first_db";
    //private  String nameDataBase = "postgres";
    private  String user = "postgres";
    private  String password = "7410";

    private String CREATE_TABLE = " create table if not exists users(id bigserial primary key not null, first_name varchar(25) not null, last_name varchar(25) not null )";

    public Db(String nameDataBase, String user, String password) {
        //this.nameDataBase = nameDataBase;
        this.user = user;
        this.password = password;
    }

    public Db() {
    }

    public void createUsersTableTable(){
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(URL,user,password);
            statement = conn.createStatement();
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void insertUser(User u){
        try (Connection connection = DriverManager.getConnection(URL, user, password); Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO users(first_name, last_name) VALUES('Ivan, 'Ivanov')");
            String sql = new Formatter().format("INSERT INTO users(first_name, last_name) VALUES('%s','%s')", u.getNameF(),u.getNameL()).toString();
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers(){
        List<User> userL = new ArrayList<>();
        String selectAll = "select id, first_name, last_name from users";
        try (Connection connection = DriverManager.getConnection(URL, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAll)) {

            while(resultSet.next()){
                long id = resultSet.getLong(1);
                String nameF = resultSet.getString(2);
                String nameL= resultSet.getString(3);
                User u = new User(id,nameF,nameL);
                userL.add(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userL;
    }

    public void deleteUserById(long id){
        try (Connection connection = DriverManager.getConnection(URL, user, password); Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO users(first_name, last_name) VALUES('Ivan, 'Ivanov')");
            String deleteUser = "delete from users where id = "+id;
            statement.execute(deleteUser);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void changeUserById(long id, String name){
        try (Connection connection = DriverManager.getConnection(URL, user, password); Statement statement = connection.createStatement()) {
            String deleteUser = "update users set first_name = '"+name+  "' where id = "+id;
            statement.execute(deleteUser);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
