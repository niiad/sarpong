module com.example.george_ohene {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.george_ohene to javafx.fxml;
    exports com.example.george_ohene;
}