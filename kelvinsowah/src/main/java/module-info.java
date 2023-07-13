module com.example.kelvinsowah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kelvinsowah to javafx.fxml;
    exports com.example.kelvinsowah;
}