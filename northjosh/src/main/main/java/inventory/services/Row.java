package inventory.services;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Row {

    private StringProperty name;
    private IntegerProperty totalSales;

    public Row(String name, int totalSales){
        this.name = new SimpleStringProperty(name);
        this.totalSales = new SimpleIntegerProperty(totalSales);
    }

    public String getName() { return name.get(); }

    public Integer getTotalSales() { return totalSales.get(); }
}
