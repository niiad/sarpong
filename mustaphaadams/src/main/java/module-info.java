module com.example.mustaphaadams {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.mustaphaadams to javafx.fxml;
    exports com.example.mustaphaadams;
}