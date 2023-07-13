module com.example.clemann {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clemann to javafx.fxml;
    exports com.example.clemann;
}