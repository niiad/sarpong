module com.gideonredemeer.awesomgideon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gideonredemeer.awesomgideon to javafx.fxml;
    exports com.gideonredemeer.awesomgideon;
}