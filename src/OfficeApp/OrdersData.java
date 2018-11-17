package OfficeApp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrdersData {
    private final StringProperty ID;
    private final StringProperty Quantity;
    private final StringProperty Price;
    private final StringProperty ClientsID;

    OrdersData(String id, String quantity, String price, String clientsID) {
        ID = new SimpleStringProperty(id);
        Quantity = new SimpleStringProperty(quantity);
        Price = new SimpleStringProperty(price);
        ClientsID = new SimpleStringProperty(clientsID);
    }

    public String getID() { return ID.get(); }

    public StringProperty IDProperty() { return ID; }

    public void setID(String ID) { this.ID.set(ID); }

    public String getQuantity() { return Quantity.get(); }

    public StringProperty quantityProperty() { return Quantity; }

    public void setQuantity(String quantity) { this.Quantity.set(quantity); }

    public String getPrice() { return Price.get(); }

    public StringProperty priceProperty() { return Price; }

    public void setPrice(String price) { this.Price.set(price); }

    public String getClientsID() { return ClientsID.get(); }

    public StringProperty clientsIDProperty() { return ClientsID; }

    public void setClientsID(String clientsID) { this.ClientsID.set(clientsID); }
}
