module com.example.alfred_appiagyei {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.alfred_appiagyei to javafx.fxml;
    exports com.example.alfred_appiagyei;
}