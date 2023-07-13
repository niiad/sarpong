module com.example.johnteyedoku {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.johnteyedoku to javafx.fxml;
    exports com.example.johnteyedoku;
}