module com.group.inventory.inventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.group20.inventory.inventory to javafx.fxml;
    exports com.group20.inventory.inventory;
    exports com.group20.inventory.inventory.controllers;
    exports com.group20.inventory.inventory.models;
    opens com.group20.inventory.inventory.controllers to javafx.fxml;
}