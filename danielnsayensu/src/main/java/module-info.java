module com.example.danielnsayensu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.danielnsayensu to javafx.fxml;
    exports com.example.danielnsayensu;
}