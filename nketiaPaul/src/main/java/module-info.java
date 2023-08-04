module com.example.nketiapaul {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nketiapaul to javafx.fxml;
    exports com.example.nketiapaul;
}