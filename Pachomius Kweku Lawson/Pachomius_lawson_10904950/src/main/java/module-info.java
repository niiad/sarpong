module com.example.pachomius_lawson_10904950 {
    requires javafx.controls;
    requires javafx.fxml;
            
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.example.pachomius_lawson_10904950 to javafx.fxml;
    exports com.example.pachomius_lawson_10904950;
}