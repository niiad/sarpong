module com.example.ziamahbless {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.ziamahbless to javafx.fxml;
	exports com.example.ziamahbless;
}