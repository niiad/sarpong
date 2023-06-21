module com.example.sarkseven {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.sarkseven to javafx.fxml;
    exports com.example.sarkseven;
}