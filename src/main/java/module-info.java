module com.example.rahinakousnah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rahinakousnah to javafx.fxml;
    exports com.example.rahinakousnah;
}