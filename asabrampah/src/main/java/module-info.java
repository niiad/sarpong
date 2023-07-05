module com.example.asabrampah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.asabrampah to javafx.fxml;
    exports com.example.asabrampah;
}