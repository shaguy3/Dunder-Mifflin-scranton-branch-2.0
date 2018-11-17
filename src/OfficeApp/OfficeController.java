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
    private TableColumn<SalesRepData, Integer> salesRepsIDColumn;
    @FXML
    private TableColumn<SalesRepData, String> salesRepsFNameColumn;
    @FXML
    private TableColumn<SalesRepData, String> salesRepsLNameColumn;
    @FXML
    private TableView<ClientsData> clientsTable;
    @FXML
    private TableColumn<ClientsData, Integer> clientsIDColumn;
    @FXML
    private TableColumn<ClientsData, String> clientsNameColumn;
    @FXML
    private TableColumn<ClientsData, String> clientsSalesRepsIDColumn;
    @FXML
    private TableView<OrdersData> ordersTable;
    @FXML
    private TableColumn<OrdersData, Integer> ordersIDColumn;
    @FXML
    private TableColumn<OrdersData, Integer> ordersQuantityColumn;
    @FXML
    private TableColumn<OrdersData, Integer> ordersPriceColumn;
    @FXML
    private TableColumn<OrdersData, Integer> ordersClientIDColumn;

    private ObservableList<SalesRepData> salesRepData;
    private ObservableList<ClientsData> clientsData;
    private ObservableList<OrdersData> ordersData;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            LoadSalesRepData();
            LoadClientData();
            LoadOrderData();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void Refresh(ActionEvent actionEvent) {
        try {
            LoadSalesRepData();
            LoadClientData();
            LoadOrderData();
        }catch (SQLException ex) {ex.printStackTrace(); }
    }

    private void LoadSalesRepData() throws SQLException{
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

    private void LoadClientData() throws SQLException{
        try {
            Connection connection = SQLiteConnection.getConnection();
            clientsData = FXCollections.observableArrayList();
            ResultSet resSet = null;
            if (connection != null) {
                resSet = connection.createStatement().executeQuery("SELECT * FROM Clients");
            }
            if (resSet != null) {
                while (resSet.next()) {
                    clientsData.add(new ClientsData(resSet.getString(1), resSet.getString(2), resSet.getString(3)));
                }
            }

            clientsIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            clientsNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
            clientsSalesRepsIDColumn.setCellValueFactory(new PropertyValueFactory<>("SalesRepID"));

            clientsTable.setItems(null);
            clientsTable.setItems(clientsData);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void LoadOrderData() throws SQLException{
        try {
            Connection connection = SQLiteConnection.getConnection();
            ordersData = FXCollections.observableArrayList();
            ResultSet resSet = null;
            if (connection != null) {
                resSet = connection.createStatement().executeQuery("SELECT * FROM Orders");
            }
            if (resSet != null) {
                while (resSet.next()) {
                    ordersData.add(new OrdersData(resSet.getString(1), resSet.getString(2), resSet.getString(3), resSet.getString(4)));
                }
            }

            ordersIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            ordersQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            ordersPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
            ordersClientIDColumn.setCellValueFactory(new PropertyValueFactory<>("ClientsID"));

            ordersTable.setItems(null);
            ordersTable.setItems(ordersData);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
