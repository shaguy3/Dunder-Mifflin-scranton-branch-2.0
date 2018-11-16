package LoginApp;

import dbUtil.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginModel {

    private Connection connection;

    LoginModel() {
        connection = SQLiteConnection.getConnection();
        if (connection == null) System.exit(1);
    }

    boolean isLogin(String user, String pass) throws Exception {
        PreparedStatement prepStat = null;
        ResultSet resSet = null;
        String sql = "SELECT * FROM Users WHERE username = ? and password = ?";

        try {
            prepStat = connection.prepareStatement(sql);
            prepStat.setString(1, user);
            prepStat.setString(2, pass);

            resSet = prepStat.executeQuery();

            return resSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            if (prepStat != null) {
                prepStat.close();
            }
            if (resSet != null) {
                resSet.close();
            }
        }
    }

    boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
