module com.example.jefferysasutweneboah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jefferysasutweneboah to javafx.fxml;
    exports com.example.jefferysasutweneboah;
}