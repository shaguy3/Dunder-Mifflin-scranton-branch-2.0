package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:OfficeDB.sqlite");
            return connection;
        } catch (Exception ex) {
            System.out.println(ex);
            return null; }
    }



}
