module com.example.benedictabervel {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.benedictabervel to javafx.fxml;
    exports com.example.benedictabervel;
}