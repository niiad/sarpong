module com.example.bridgetyeboah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bridgetyeboah to javafx.fxml;
    exports com.example.bridgetyeboah;
}