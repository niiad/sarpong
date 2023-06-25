module com.example.emmanueldjangmah {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.emmanueldjangmah to javafx.fxml;
    exports com.example.emmanueldjangmah;
}