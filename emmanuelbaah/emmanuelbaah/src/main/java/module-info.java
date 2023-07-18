module com.example.emmanuelbaah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emmanuelbaah to javafx.fxml;
    exports com.example.emmanuelbaah;
}