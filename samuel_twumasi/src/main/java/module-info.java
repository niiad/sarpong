module com.example.samuel_twumasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.samuel_twumasi to javafx.fxml;
    exports com.example.samuel_twumasi;
}