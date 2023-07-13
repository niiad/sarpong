module com.example.dennissakyiama {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dennissakyiama to javafx.fxml;
    exports com.example.dennissakyiama;
}