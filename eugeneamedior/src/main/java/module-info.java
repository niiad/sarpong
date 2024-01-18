module com.example.eugeneamedior {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eugeneamedior to javafx.fxml;
    exports com.example.eugeneamedior;
}