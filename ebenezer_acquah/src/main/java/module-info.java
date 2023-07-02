module com.example.ebenezer_acquah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ebenezer_acquah to javafx.fxml;
    exports com.example.ebenezer_acquah;
}