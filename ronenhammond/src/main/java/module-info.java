module com.example.ronenhammond {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ronenhammond to javafx.fxml;
    exports com.example.ronenhammond;
}