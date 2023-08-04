module com.example.alexis_addo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.alexis_addo to javafx.fxml;
    exports com.example.alexis_addo;
    exports com.example.alexis_addo.controlller;
    opens com.example.alexis_addo.controlller to javafx.fxml;
    exports com.example.alexis_addo.model.dataStructures;
    opens com.example.alexis_addo.model.dataStructures to javafx.fxml;
}