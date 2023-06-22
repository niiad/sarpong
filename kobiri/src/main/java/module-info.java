module com.example.kobiri {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kobiri to javafx.fxml;
    exports com.example.kobiri;
}