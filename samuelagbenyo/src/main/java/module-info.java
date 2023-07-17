module com.example.samuelagbenyo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.samuelagbenyo to javafx.fxml;
    exports com.example.samuelagbenyo;
}