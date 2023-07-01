module com.example.jojojacob {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jojojacob to javafx.fxml;
    exports com.example.jojojacob;
}