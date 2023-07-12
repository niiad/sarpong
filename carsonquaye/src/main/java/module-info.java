module com.example.carsonquaye {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carsonquaye to javafx.fxml;
    exports com.example.carsonquaye;
}