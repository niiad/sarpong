module com.example.kparibkenneth {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kparibkenneth to javafx.fxml;
    exports com.example.kparibkenneth;
}