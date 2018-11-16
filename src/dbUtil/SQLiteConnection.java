package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:OfficeDB.sqlite");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; }
    }



}
