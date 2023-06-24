module com.example.emmanuel_yeboah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emmanuel_yeboah to javafx.fxml;
    exports com.example.emmanuel_yeboah;
}