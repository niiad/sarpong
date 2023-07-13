module com.example.amarteydillion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.amarteydillion to javafx.fxml;
    exports com.example.amarteydillion;
}