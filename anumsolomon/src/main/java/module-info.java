module com.example.anumsolomon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.anumsolomon to javafx.fxml;
    exports com.example.anumsolomon;
}