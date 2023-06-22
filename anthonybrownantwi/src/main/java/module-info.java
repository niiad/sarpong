module com.example.anthonybrownantwi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.anthonybrownantwi to javafx.fxml;
    exports com.example.anthonybrownantwi;
}