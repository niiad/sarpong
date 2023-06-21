module com.example.kofiandohsilas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kofiandohsilas to javafx.fxml;
    exports com.example.kofiandohsilas;
}