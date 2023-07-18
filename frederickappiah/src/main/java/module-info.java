module com.example.frederickappiah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.frederickappiah to javafx.fxml;
    exports com.example.frederickappiah;
}