module com.example.adeiyjacksonkofi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.adeiyjacksonkofi to javafx.fxml;
    exports com.example.adeiyjacksonkofi;
}