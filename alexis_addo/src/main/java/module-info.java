module com.example.alexis_addo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.alexis_addo to javafx.fxml;
    exports com.example.alexis_addo;
}