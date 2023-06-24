module com.example.maikellamps {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maikellamps to javafx.fxml;
    exports com.example.maikellamps;
}