module com.example.nawashutchful {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nawashutchful to javafx.fxml;
    exports com.example.nawashutchful;
}