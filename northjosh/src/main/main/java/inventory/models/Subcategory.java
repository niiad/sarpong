package inventory.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subcategory {
    private IntegerProperty subcategoryId;
    private StringProperty subcategoryName;

    public Subcategory() {
    }

    public Subcategory(int id, String name) {
        this.subcategoryId = new SimpleIntegerProperty(id);
        this.subcategoryName = new SimpleStringProperty(name);
    }

    public int getSubcategoryId() { return subcategoryId.get(); }

    public String getSubcategoryName() { return subcategoryName.get(); }

    public void setSubcategoryId(int id) { this.subcategoryId.set(id); }

    public void setSubcategoryName(String name) { this.subcategoryName.set(name); }
}
