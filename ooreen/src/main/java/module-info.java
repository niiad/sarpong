module com.example.ooreen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ooreen to javafx.fxml;
    exports com.example.ooreen;
}