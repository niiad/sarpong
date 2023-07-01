module com.otumichael.otumichael {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansoloOt.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.otumichael to javafx.fxml;
    exports com.otumichael;
}