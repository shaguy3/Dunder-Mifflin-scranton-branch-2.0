package OfficeApp;

import dbUtil.SQLiteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OfficeController implements Initializable {

    @FXML
    private TableView<SalesRepData> salesRepTable;
    @FXML
    private TableColumn<SalesRepData, Integer> salesRepsIDColumn; //Maybe Integer instead of String
    @FXML
    private TableColumn<SalesRepData, String> salesRepsFNameColumn;
    @FXML
    private TableColumn<SalesRepData, String> salesRepsLNameColumn;

    private ObservableList<SalesRepData> salesRepData;

    public void initialize(URL location, ResourceBundle resources) {
        try { LoadSalesRepData(); } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void LoadSalesRepData() throws SQLException{
        try {
            Connection connection = SQLiteConnection.getConnection();
            salesRepData = FXCollections.observableArrayList();
            ResultSet resSet = null;
            if (connection != null) {
                resSet = connection.createStatement().executeQuery("SELECT * FROM SalesReps");
            }
            if (resSet != null) {
                while (resSet.next()) {
                    salesRepData.add(new SalesRepData(resSet.getString(1), resSet.getString(2), resSet.getString(3)));
                }
            }

            salesRepsIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            salesRepsFNameColumn.setCellValueFactory(new PropertyValueFactory<>("FName"));
            salesRepsLNameColumn.setCellValueFactory(new PropertyValueFactory<>("LName"));

            salesRepTable.setItems(null);
            salesRepTable.setItems(salesRepData);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void LoadSalesRepData(ActionEvent actionEvent) throws SQLException{
        try {
            Connection connection = SQLiteConnection.getConnection();
            salesRepData = FXCollections.observableArrayList();
            ResultSet resSet = null;
            if (connection != null) {
                resSet = connection.createStatement().executeQuery("SELECT * FROM SalesReps");
            }
            if (resSet != null) {
                while (resSet.next()) {
                    salesRepData.add(new SalesRepData(resSet.getString(1), resSet.getString(2), resSet.getString(3)));
                }
            }

            salesRepsIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            salesRepsFNameColumn.setCellValueFactory(new PropertyValueFactory<>("FName"));
            salesRepsLNameColumn.setCellValueFactory(new PropertyValueFactory<>("LName"));

            salesRepTable.setItems(null);
            salesRepTable.setItems(salesRepData);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
