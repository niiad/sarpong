module com.example.obedattepor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.obedattepor to javafx.fxml;
    exports com.example.obedattepor;
}