module com.example.lesleyedinamabotsi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.lesleyedinamabotsi to javafx.fxml;
    exports com.example.lesleyedinamabotsi;
}