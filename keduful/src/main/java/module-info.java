module com.example.keduful {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.keduful to javafx.fxml;
    exports com.example.keduful;
    exports com.example.keduful.controller;
    opens com.example.keduful.controller to javafx.fxml;
}