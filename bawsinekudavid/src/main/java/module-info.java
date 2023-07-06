module com.example.davidbawsineku {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.davidbawsineku to javafx.fxml;
    exports com.example.davidbawsineku;
}