module com.example._308project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._308project to javafx.fxml;
    exports com.example._308project;
}