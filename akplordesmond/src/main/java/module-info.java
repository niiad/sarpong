module com.example.akplordesmond {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.akplordesmond to javafx.fxml;
    exports com.example.akplordesmond;
}