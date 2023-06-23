module com.example.sycudjoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sycudjoe to javafx.fxml;
    exports com.example.sycudjoe;
}