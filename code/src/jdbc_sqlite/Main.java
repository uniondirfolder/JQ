package jdbc_sqlite;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        try {

            // statement.executeUpdate("INSERT INTO students (name, score) VALUES('Bob3',100)");
            // select();
           // update();
            // delete1();
            // deleteAll();
            // deleteTable();

            //transActionPrepStatem();

            //executeBach();

             rollback();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void rollback() throws SQLException {
        statement.executeUpdate("INSERT.....");
        Savepoint sp1 = connection.setSavepoint();
        statement.executeUpdate("INSERT.....");
        connection.rollback(sp1);
        statement.executeUpdate("INSERT.....");
        connection.commit();
    }

    private static void executeBach() throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?,?);");
        connection.setAutoCommit(false);
        for (int i = 1; i < 10_000; i++) {
            preparedStatement.setString(1, "Bob"+(i));
            preparedStatement.setInt(2, 25+i);
            // preparedStatement.setObject();
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();
    }

    private static void transActionPrepStatem() throws SQLException {
        connect();
        deleteTable();
        createTable();
        preparedStatement = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?,?);");
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i < 10_000; i++) {
            preparedStatement.setString(1, "Bob"+(i));
            preparedStatement.setInt(2, 25+i);
            // preparedStatement.setObject();
            preparedStatement.executeUpdate();
        }
        connection.commit();
        System.out.println(System.currentTimeMillis()-time);
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE users (id   INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age  INT);" );
    }

    private static void deleteTable() throws SQLException {
        statement.executeUpdate("DROP TABLE users");
    }

    private static void deleteAll() throws SQLException {
        statement.executeUpdate("DELETE FROM users");
    }

    private static void delete1() throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE id = 3");
    }

    private static void update() throws SQLException {
        statement.executeUpdate("UPDATE students SET score = 80 WHERE id = 1");
    }

    private static void select() {
        try (ResultSet rs = statement.executeQuery("select * from students;");) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            String sqlUrl = "jdbc:sqlite:C:\\REPO\\JQ\\temp\\main.db";
            connection = DriverManager.getConnection(sqlUrl);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
