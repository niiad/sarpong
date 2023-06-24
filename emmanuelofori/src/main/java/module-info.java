module com.example.emmanuelofori {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emmanuelofori to javafx.fxml;
    exports com.example.emmanuelofori;
}