module com.baabadampare.baabadampare {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.baabadampare.baabadampare to javafx.fxml;
    exports com.baabadampare.baabadampare;
}