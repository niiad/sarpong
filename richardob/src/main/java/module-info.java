module com.example.richardob {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.richardob to javafx.fxml;
    exports com.example.richardob;
}