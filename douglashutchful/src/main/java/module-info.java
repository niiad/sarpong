module com.example.douglashutchful {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.douglashutchful to javafx.fxml;
    exports com.example.douglashutchful;
}