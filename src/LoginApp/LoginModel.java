package LoginApp;

import dbUtil.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    Connection connection;

    public LoginModel() {
        connection = SQLiteConnection.getConnection();
        if (connection == null) System.exit(1);
    }

    public boolean isLogin(String user, String pass) throws Exception {
        PreparedStatement prepStat = null;
        ResultSet resSet = null;
        String sql = "SELECT * FROM Users WHERE username = ? and password = ?";

        try {
            prepStat = connection.prepareStatement(sql);
            prepStat.setString(1, user);
            prepStat.setString(2, pass);

            resSet = prepStat.executeQuery();

            if (resSet.next())
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            prepStat.close();
            resSet.close();
        }
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
