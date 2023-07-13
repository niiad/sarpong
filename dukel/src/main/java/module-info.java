module com.example.dukel {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.dukel to javafx.fxml;
    exports com.example.dukel;
}