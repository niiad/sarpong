module com.example.papayawntim {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.papayawntim to javafx.fxml;
    exports com.example.papayawntim;
}