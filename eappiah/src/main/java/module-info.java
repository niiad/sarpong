module com.example.eappiah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eappiah to javafx.fxml;
    exports com.example.eappiah;
}