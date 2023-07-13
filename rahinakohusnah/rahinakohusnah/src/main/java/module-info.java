module com.example.rahinakohusnah {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.rahinakohusnah to javafx.fxml;
    exports com.example.rahinakohusnah;
}