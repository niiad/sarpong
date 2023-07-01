module com.example.alfredappiagyei {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alfredappiagyei to javafx.fxml;
    exports com.example.alfredappiagyei;
}