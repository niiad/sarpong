module com.example.akosuayeboah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.akosuayeboah to javafx.fxml;
    exports com.example.akosuayeboah;
}