module com.example.edemkwaku {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.edemkwaku to javafx.fxml;
    exports com.example.edemkwaku;
}