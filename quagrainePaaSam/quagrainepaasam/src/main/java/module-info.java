module com.example.quagrainepaasam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quagrainepaasam to javafx.fxml;
    exports com.example.quagrainepaasam;
}