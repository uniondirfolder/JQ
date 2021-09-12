package lection.l18_l19JDBC;

public class Main {
    public static void main(String[] args) {

//        try {
//            Connection conn = DriverManager.getConnection(url,user,password);
//            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts(first_name VARCHAR, last_name VARCHAR)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Db db = new Db();
        db.createUsersTableTable();
        db.insertUser(new User(0, "Ivan", "Inoty"));
        System.out.println(db.getAllUsers());
        //db.deleteUserById(1);
        db.changeUserById(2, "Fop");

        System.out.println(db.getAllUsers());
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