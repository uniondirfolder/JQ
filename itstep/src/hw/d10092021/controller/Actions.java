package hw.d10092021.controller;

import hw.d10092021.model.Group;
import hw.d10092021.model.Task;
import hw.d10092021.sql.enums.DB;
import hw.d10092021.sql.enums.SQLite;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.sql.exeptions.SQLExceptionForeignKey;
import hw.d10092021.utils.Commands;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actions implements Action {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private final String driver;
    private final String sqlUrl;
    private Commands cmd;

    public Actions(String driver, String sqlUrl) {
        this.driver = driver;
        this.sqlUrl = sqlUrl;
        cmd = new Commands();
        //createTable();
    }

    private void connect() throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to connect");
        }
    }

    private void disconnect() {
        try {
            if (preparedStatement != null) {
                if (!preparedStatement.isClosed()) {
                    preparedStatement.clearParameters();
                    preparedStatement.close();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (statement != null) {
                if (!statement.isClosed()) {
                    statement.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void createTable() {
        try {
            connect();
            statement.executeUpdate(cmd.create(DB.SQLITE, SQLite.TABLE, new Group()));
            statement.executeUpdate(cmd.create(DB.SQLITE, SQLite.TABLE, new Task()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        addCategory(new Group("Программирование"));
        addCategory(new Group("Покупка"));
        addCategory(new Group("Уборка"));
        try {
            addTask(new Task(0, new Date().getTime(), "Готовиться к собесу по Java", 1));
        } catch (SQLExceptionFieldLength e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLExceptionForeignKey e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Group grp) {
        try {
            connect();
            preparedStatement = connection.prepareStatement(cmd.create(DB.SQLITE, SQLite.RECORD, grp));
            preparedStatement.setString(1, grp.getName());
            preparedStatement.setLong(2, 0);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public void addTask(Task task) {
        try {
            connect();
            preparedStatement = connection.prepareStatement(cmd.create(DB.SQLITE, SQLite.RECORD, task));
            preparedStatement.setLong(1, task.getCreatedDate());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setLong(3, task.getGroup_id());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public void renameGroup(Group grp) {
        try {
            connect();
            preparedStatement = connection.prepareStatement(cmd.update(DB.SQLITE, SQLite.RECORD, grp));
            preparedStatement.setString(1, grp.getName());
            preparedStatement.setLong(2, grp.getRelation());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    @Override
    public void updateTask(Task task) {
        try {
            connect();

            String str = cmd.update(DB.SQLITE, SQLite.RECORD, task) + task.getId()+";";
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setLong(1, task.getId());
            preparedStatement.setLong(2, task.getCreatedDate());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setLong(4, task.getGroup_id());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public void removeTask(Task task) {
        try {
            connect();
            String str = cmd.delete(DB.SQLITE, SQLite.RECORD, task);
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setLong(1, task.getId());
            preparedStatement.executeUpdate();
            //statement.executeUpdate(cmd.delete(DB.SQLITE, SQLite.RECORD, task));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public List<Group> getCategories() {
        List<Group> list = new ArrayList<>();
        try {
            connect();
            ResultSet rs = statement.executeQuery(cmd.read(DB.SQLITE, SQLite.TABLE, new Group()));
            //ResultSet rs = statement.executeQuery("SELECT * FROM CATEGORY");
            if (rs != null) {
                while (rs.next()) {
                    list.add(new Group(rs.getLong(1), rs.getString(2), rs.getLong(3)));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return null;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        try {
            connect();

            ResultSet rs = statement.executeQuery(cmd.read(DB.SQLITE, SQLite.TABLE, new Task(0, 0,null,0)));
            if (rs != null) {

                while (rs.next()) {
                    list.add(new Task(rs.getLong(1),rs.getLong(2), rs.getString(3), rs.getLong(4)));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

}
