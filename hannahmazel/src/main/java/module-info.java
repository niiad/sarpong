module com.example.hannahmazel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hannahmazel to javafx.fxml;
    exports com.example.hannahmazel;
}