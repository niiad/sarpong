module com.example.ransfordgyasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ransfordgyasi to javafx.fxml;
    exports com.example.ransfordgyasi;
}