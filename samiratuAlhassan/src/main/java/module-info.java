module com.example.samiratualhassan {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.samiratualhassan to javafx.fxml;
    exports com.example.samiratualhassan;
}