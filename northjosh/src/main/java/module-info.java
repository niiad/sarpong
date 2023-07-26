module com.example.northjosh {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.northjosh to javafx.fxml;
    exports com.example.northjosh;
}