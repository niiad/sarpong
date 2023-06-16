module com.eduful9788.kelvineduful {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eduful9788.kelvineduful to javafx.fxml;
    exports com.eduful9788.kelvineduful;
}