package OfficeApp;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginModel {

    Connection connection;

    public LoginModel() {
        connection = SQLiteConnection.getConnection();
        if (connection == null) System.exit(1);
    }

    public boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
