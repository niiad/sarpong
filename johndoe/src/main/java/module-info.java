module com.example.johndoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.johndoe to javafx.fxml;
    exports com.example.johndoe;
}