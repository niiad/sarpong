module com.example.paulisrael {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paulisrael to javafx.fxml;
    exports com.example.paulisrael;
}