package LoginApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbStatus;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label loginStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (loginModel.isConnected()) {
            dbStatus.setText("Connected to database!");
        } else {
            dbStatus.setText("Not connected to database");
        }
    }

    @FXML
    public void Login(ActionEvent actionEvent) {
        try {
            if (loginModel.isLogin(userField.getText(), passField.getText())) {

                Stage stage = (Stage) this.loginBtn.getScene().getWindow();
                stage.close();

                try {
                    Stage userStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Pane root = loader.load(getClass().getResource("/OfficeApp/OfficeApp.fxml").openStream());

                    Scene scene = new Scene(root);
                    userStage.setScene(scene);
                    userStage.setTitle("Office dashboard");
                    userStage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else loginStatus.setText("Wrong credentials");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
