module com.example.eduful {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eduful to javafx.fxml;
    exports com.example.eduful;
}