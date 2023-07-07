module com.example.calebasare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calebasare to javafx.fxml;
    exports com.example.calebasare;
}