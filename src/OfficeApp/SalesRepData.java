package OfficeApp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesRepData {
    private final StringProperty ID;
    private final StringProperty FName;
    private final StringProperty LName;

    public SalesRepData(String id, String fName, String lName) {
        ID = new SimpleStringProperty(id);
        FName = new SimpleStringProperty(fName);
        LName = new SimpleStringProperty(lName);
    }

    public String getID() { return ID.get(); }

    public StringProperty IDProperty() { return ID; }

    public void setID(String ID) { this.ID.set(ID); }

    public String getFName() { return FName.get(); }

    public StringProperty FNameProperty() { return FName; }

    public void setFName(String FName) { this.FName.set(FName); }

    public String getLName() { return LName.get(); }

    public StringProperty LNameProperty() { return LName; }

    public void setLName(String LName) { this.LName.set(LName); }
}
