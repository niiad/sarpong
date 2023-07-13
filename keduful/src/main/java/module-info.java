module com.example.keduful {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.keduful to javafx.fxml;
    exports com.example.keduful;
}