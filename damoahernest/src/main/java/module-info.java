module com.example.damoahernest {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.damoahernest to javafx.fxml;
    exports com.example.damoahernest;
}