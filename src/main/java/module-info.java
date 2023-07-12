module com.example.carsonquaye {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.carsonquaye to javafx.fxml;
    exports com.example.carsonquaye;
}