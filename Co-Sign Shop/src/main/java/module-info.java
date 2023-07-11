module com.example.cosignshop {
    requires javafx.controls;
    requires javafx.fxml;

//    MySQL Connection
    requires java.sql;


    opens com.example.cosignshop to javafx.fxml;
    exports com.example.cosignshop;
    exports com.example.cosignshop.Controller;
    opens com.example.cosignshop.Controller to javafx.fxml;
    exports com.example.cosignshop.Data;
    opens com.example.cosignshop.Data to javafx.fxml;
    exports com.example.cosignshop.Repository;
    opens com.example.cosignshop.Repository to javafx.fxml;
}