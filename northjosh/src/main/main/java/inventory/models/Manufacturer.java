package inventory.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Manufacturer {
    private IntegerProperty manufacturerId;
    private StringProperty manufacturerName;

    public Manufacturer() {
    }

    public Manufacturer(int id, String name) {
        this.manufacturerId = new SimpleIntegerProperty(id);
        this.manufacturerName = new SimpleStringProperty(name);
    }

    public int getManufacturerId() { return manufacturerId.get(); }

    public String getManufacturerName() { return manufacturerName.get(); }

    public void setManufacturerId(int id) {this.manufacturerId.set(id); }

    public void setManufacturerName(String name) {this.manufacturerName.set(name); }
}
