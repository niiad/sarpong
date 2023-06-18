module com.example.tracyopoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tracyopoku to javafx.fxml;
    exports com.example.tracyopoku;
}