module com.example.rexford_brefo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.rexford_brefo to javafx.fxml;
    exports com.example.rexford_brefo;
}