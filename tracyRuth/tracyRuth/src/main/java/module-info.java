module com.example.tracyruth {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tracyruth to javafx.fxml;
    exports com.example.tracyruth;
}