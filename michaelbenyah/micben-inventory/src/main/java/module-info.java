module com.example.micbeninventory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.micbeninventory to javafx.fxml;
    exports com.example.micbeninventory;
    exports com.example.micbeninventory.controller;
    opens com.example.micbeninventory.controller to javafx.fxml;
}