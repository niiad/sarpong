module com.example.berniceabena {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.berniceabena to javafx.fxml;
    exports com.example.berniceabena;
}