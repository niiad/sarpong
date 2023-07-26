module com.example.niiadotei {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.niiadotei to javafx.fxml;
    exports com.example.niiadotei;
}