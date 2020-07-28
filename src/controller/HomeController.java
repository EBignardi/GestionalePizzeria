package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import manager.WindowsManager;

public class HomeController implements Initializable{
	
	private static String username = "pizzapazza";
	private static String pass = "1234";
	
    @FXML // fx:id="homePane"
    private BorderPane homePane; // Value injected by FXMLLoader
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private TextField txtPassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnTitolare"
    private Button btnTitolare; // Value injected by FXMLLoader

    @FXML // fx:id="btnCliente"
    private Button btnCliente; // Value injected by FXMLLoader
    
    @FXML // fx:id="SuggerimentoUsername"
    private Label SuggerimentoUsername; // Value injected by FXMLLoader

    @FXML // fx:id="SuggerimentoPassword"
    private Label SuggerimentoPassword; // Value injected by FXMLLoader

    @FXML // fx:id="Suggerimento"
    private Label Suggerimento; // Value injected by FXMLLoader
    
    public Scene start() throws Exception {
    	Parent par = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
    
    	//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene homeScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());
    	return homeScene;
    }
    
    @FXML
    void buttonClienteAction(ActionEvent event) throws Exception {
    	System.out.println("APERTURA Finestra Cliente");
    	WindowsManager.setCliente();
    }

    @FXML
    void buttonTitolareAction(ActionEvent event) throws Exception {
    	
    	System.out.println("Verifico Credenziali Titolare");
    	if((txtUsername.getText().equals(username)) && txtPassword.getText().equals(pass)) {
		WindowsManager.setTitolare();
    	}
    	else {
    	Suggerimento.setText("Prova con : ");
    	SuggerimentoUsername.setText(username);
    	SuggerimentoPassword.setText(pass);
    	}
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnTitolare != null : "fx:id=\"btnTitolare\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnCliente != null : "fx:id=\"btnCliente\" was not injected: check your FXML file 'Home.fxml'.";
		
	}
	
	
}
