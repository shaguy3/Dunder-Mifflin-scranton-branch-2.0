package OfficeApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public LoginModel loginModel = new LoginModel();

    @FXML
    Label dbStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (loginModel.isConnected()) {
            dbStatus.setText("Connected to database!");
        } else {
            dbStatus.setText("Not connected to database");
        }
    }

    //TODO add showing methods (show employees, show clients, and show orders)
}
