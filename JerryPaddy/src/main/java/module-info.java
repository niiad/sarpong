module com.example.jerrypaddy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.jerrypaddy to javafx.fxml;
    exports com.example.jerrypaddy;
}