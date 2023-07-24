module com.example.elizabethbarasu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elizabethbarasu to javafx.fxml;
    exports com.example.elizabethbarasu;
}