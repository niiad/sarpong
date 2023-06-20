module com.example.david_boateng {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.david_boateng to javafx.fxml;
    exports com.example.david_boateng;
}