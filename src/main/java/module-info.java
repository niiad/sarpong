module com.example.richardyemofio {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.richardyemofio to javafx.fxml;
    exports com.example.richardyemofio;
}