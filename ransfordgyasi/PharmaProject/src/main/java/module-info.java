module com.example.pharmaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pharmaproject to javafx.fxml;
    exports com.example.pharmaproject;
}