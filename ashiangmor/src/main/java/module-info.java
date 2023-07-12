module com.ashiangmor.ashiangmor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ashiangmor.app to javafx.fxml;
    exports com.ashiangmor.app;
}