module nyonyo589.userlogin {

    requires  javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires fontawesomefx;


//    opens nyonyo589.finalproject to javafx.fxml;
    opens nyonyo589.finalproject;
//    exports nyonyo589.finalproject;
}