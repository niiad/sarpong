module com.example.mukadas_maltiti {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.mukadas_maltiti to javafx.fxml;
    exports com.example.mukadas_maltiti;
}