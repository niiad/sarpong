module com.example.mimi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mimi to javafx.fxml;
    exports com.example.mimi;
}