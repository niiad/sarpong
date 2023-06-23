module com.example.stephaniekudadze {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stephaniekudadze to javafx.fxml;
    exports com.example.stephaniekudadze;
}