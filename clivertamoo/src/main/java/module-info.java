module com.example.clivertamoo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.clivertamoo to javafx.fxml;
    exports com.example.clivertamoo;
}