package OfficeApp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClientsData {
    private final StringProperty ID;
    private final StringProperty Name;
    private final StringProperty SalesRepID;

    ClientsData(String id, String name, String salesRepID) {
        ID = new SimpleStringProperty(id);
        Name = new SimpleStringProperty(name);
        SalesRepID = new SimpleStringProperty(salesRepID);
    }

    public String getID() { return ID.get(); }

    public StringProperty IDProperty() { return ID; }

    public void setID(String ID) { this.ID.set(ID); }

    public String getName() { return Name.get(); }

    public StringProperty nameProperty() { return Name; }

    public void setName(String name) { this.Name.set(name); }

    public String getSalesRepID() { return SalesRepID.get(); }

    public StringProperty salesRepIDProperty() { return SalesRepID; }

    public void setSalesRepID(String salesRepID) { this.SalesRepID.set(salesRepID); }
}
