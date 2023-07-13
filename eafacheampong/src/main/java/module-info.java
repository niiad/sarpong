module com.example.eafacheampong {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.eafacheampong to javafx.fxml;
    exports com.example.eafacheampong;
}