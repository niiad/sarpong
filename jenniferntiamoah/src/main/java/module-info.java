module com.example.jenniferntiamoah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jenniferntiamoah to javafx.fxml;
    exports com.example.jenniferntiamoah;
}