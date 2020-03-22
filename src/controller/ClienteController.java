package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.joda.time.LocalTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import manager.WindowsManager;
import model.*;

public class ClienteController implements Initializable {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="tabOrdini"
	private TableView<ClienteSpedizione> tabOrdini; // Value injected by FXMLLoader

	@FXML // fx:id="colonnaOrario"
	private TableColumn<ClienteSpedizione, LocalTime> colOrario; // Value injected by FXMLLoader

	@FXML // fx:id="colonnaIndirizzo"
	private TableColumn<ClienteSpedizione, String> colIndirizzo; // Value injected by FXMLLoader

	@FXML // fx:id="colonnaPizze"
	private TableColumn<ClienteSpedizione, Pizza> colPizze; // Value injected by FXMLLoader

	@FXML // fx:id="orarioCliente"
	private ComboBox<LocalTime> orarioCliente; // Value injected by FXMLLoader
	
	@FXML // fx:id="txtNomeCliente"
	private TextField txtNomeCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtTelefonoCliente"
	private TextField txtTelefonoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtIndirizzoCliente"
	private TextField txtIndirizzoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtCivicoCliente"
	private TextField txtCivicoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="dataCliente"
	private DatePicker dataCliente; // Value injected by FXMLLoader

	@FXML // fx:id="btnSelezionePizze"
	private Button btnSelezionePizze; // Value injected by FXMLLoader

	@FXML // fx:id="btnSelezioneBevande"
	private Button btnSelezioneBevande; // Value injected by FXMLLoader

	@FXML
	void buttonPizzeAction(ActionEvent event) throws Exception {
		System.out.println("Salvataggio dei dati relativi al cliente: \n"+ 
				txtNomeCliente.getText() + "\n" + txtTelefonoCliente.getText() + "\n" + txtCivicoCliente.getText() + "\n" +
				dataCliente.toString() + "\n" + orarioCliente.toString());
		
		System.out.println("APERTURA Finestra Scelta delle Pizze");
		WindowsManager.setPizza();
	}

	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Cliente.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		assert tabOrdini != null : "fx:id=\"tabOrdini\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colOrario != null : "fx:id=\"colonnaOrario\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colIndirizzo != null : "fx:id=\"colonnaIndirizzo\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colPizze != null : "fx:id=\"colonnaPizze\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert orarioCliente != null : "fx:id=\"orarioCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtNomeCliente != null : "fx:id=\"txtNomeCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtTelefonoCliente != null : "fx:id=\"txtTelefonoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtIndirizzoCliente != null : "fx:id=\"txtIndirizzoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtCivicoCliente != null : "fx:id=\"txtCivicoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert dataCliente != null : "fx:id=\"dataCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert btnSelezionePizze != null : "fx:id=\"btnSelezionePizze\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert btnSelezioneBevande != null : "fx:id=\"btnSelezioneBevande\" was not injected: check your FXML file 'Cliente.fxml'.";
		
		/**
		//inizializzazione delle colonne della tabella riepilogo ordini
		colOrario.setCellValueFactory(cellData -> cellData.getValue().getOrario().asObject());
		colIndirizzo.setCellValueFactory(cellData -> cellData.getValue().getIndirizzoProperty().asObject());
		colPizze.setCellValueFactory(cellData -> cellData.getValue().getElencoPizze());
		**/
		
	}
}
