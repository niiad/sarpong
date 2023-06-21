module com.example.brefo_rexford {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.brefo_rexford to javafx.fxml;
    exports com.example.brefo_rexford;
}