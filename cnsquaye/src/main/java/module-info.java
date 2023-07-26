module com.example.cnsquaye {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cnsquaye to javafx.fxml;
    exports com.example.cnsquaye;
}