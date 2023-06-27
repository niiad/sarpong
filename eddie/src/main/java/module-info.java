module com.example.eddie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eddie to javafx.fxml;
    exports com.example.eddie;
}