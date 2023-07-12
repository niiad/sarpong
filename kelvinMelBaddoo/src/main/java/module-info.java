module com.example.kelvinmelbaddoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kelvinmelbaddoo to javafx.fxml;
    exports com.example.kelvinmelbaddoo;
}