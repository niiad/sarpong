module com.example.niiadotei {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.niiadotei to javafx.fxml;
    exports com.example.niiadotei;
    exports com.example.niiadotei.controller;
    opens com.example.niiadotei.controller to javafx.fxml;
}