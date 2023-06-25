module com.example.amaning {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.amaning to javafx.fxml;
    exports com.example.amaning;
}