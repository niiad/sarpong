module com.example.caleblotoo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.caleblotoo to javafx.fxml;
    exports com.example.caleblotoo;
}