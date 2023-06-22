module com.example.ronenham {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ronenham to javafx.fxml;
    exports com.example.ronenham;
}