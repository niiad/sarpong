module com.example.manuel69 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.manuel69 to javafx.fxml;
    exports com.example.manuel69;
}