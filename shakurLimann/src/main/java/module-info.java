module com.example.limannshakur {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.limannshakur to javafx.fxml;
    exports com.example.limannshakur;
}