module com.example.charlesappiah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.charlesappiah to javafx.fxml;
    exports com.example.charlesappiah;
}