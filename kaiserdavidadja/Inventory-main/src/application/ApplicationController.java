package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class ApplicationController implements Initializable {
	Goods Coke;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Coke = new Goods();
		Coke.setName("Coke");
		System.out.println(Coke.getName()+" = "+Coke.getQuantity());
		
	}
	
}
