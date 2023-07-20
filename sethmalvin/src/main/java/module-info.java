module com.example.sethmalvin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sethmalvin to javafx.fxml;
    exports com.example.sethmalvin;
}