module com.example.ankuobed {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ankuobed to javafx.fxml;
    exports com.example.ankuobed;
}