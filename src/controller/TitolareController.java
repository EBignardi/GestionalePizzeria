package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class TitolareController implements Initializable {

	@FXML
	private Label userlbl;
	
	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Titolare.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void getUsername(String username) {
		// TODO Auto-generated method stub
		userlbl.setText(username);
	}
}
