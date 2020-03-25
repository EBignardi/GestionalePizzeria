package controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import dataAccessObject.ClienteDAO;
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
import model.ClienteSpedizione;
import model.Pizza;

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

	//formatter utilizzati per DATA e ORARIO
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yy");
	DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");

	@FXML
	void buttonPizzeAction(ActionEvent event) throws Exception {
		System.out.println("Controllo dei dati inseriti riguardanti il Cliente");
		
		if(!(StringUtils.isAlpha(txtNomeCliente.getText())))
			System.out.println("Nome Cliente NON valido");
		
		if((!(StringUtils.isNumeric(txtTelefonoCliente.getText()))) || (txtTelefonoCliente.getText().length() > 11))
			System.out.println("Numero Telefono NON valido");
		
		if(!(StringUtils.isAlpha(txtNomeCliente.getText())))
			System.out.println("Indirizzo NON valido");
		
		if(!(StringUtils.isNumeric(txtCivicoCliente.getText())))
			System.out.println("Civico NON valido");
		
		if (((dataCliente.getValue().format(formatoData)).compareTo(LocalDate.now().format(formatoData)) < 0))
			System.out.println("Data inserita NON valida");
		
		//Nella data odierna non posso prendere ordini con una data inferiore a quella attuale
		if (((dataCliente.getValue()).isEqual(LocalDate.now())) && (orarioCliente.getValue().isBefore(LocalTime.now())))
			System.out.println("Orario inserito NON valido");
		
		System.out.println("Salvataggio dei dati relativi al cliente: \n" + 
				"Nome: " + txtNomeCliente.getText() + "\n" + 
				"Telefono: " + txtTelefonoCliente.getText() + "\n" +
				"Indirizzo: " + txtIndirizzoCliente.getText() + "\n" +
				"Civico: " + txtCivicoCliente.getText() + "\n" +
				"Data Ordine: " + dataCliente.getValue().format(formatoData) + "\n" + 
				"Orario Ordine: " + orarioCliente.getValue().format(formatoOra));
		
		//inserisco i dati nel DataBase nella Tabella Cliente
		ClienteDAO.insertCliente(txtNomeCliente.getText(), txtTelefonoCliente.getText(), txtIndirizzoCliente.getText(),  
								txtCivicoCliente.getText(), dataCliente.getValue().format(formatoData), orarioCliente.getValue().format(formatoOra));
		
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
		
		//inizializzo i valori della ComboBox orario
		orarioCliente.getItems().addAll(LocalTime.now(),
										LocalTime.parse("18:30"), LocalTime.parse("18:45"),
										LocalTime.parse("19:00"), LocalTime.parse("19:15"), LocalTime.parse("19:30"), LocalTime.parse("19:45"), 
										LocalTime.parse("20:00"), LocalTime.parse("20:15"), LocalTime.parse("20:30"), LocalTime.parse("20:45"),
										LocalTime.parse("21:00"), LocalTime.parse("21:15"), LocalTime.parse("21:30"), LocalTime.parse("21:45"),
										LocalTime.parse("22:00"), LocalTime.parse("22:15"), LocalTime.parse("22:30"), LocalTime.parse("22:45"),
										LocalTime.parse("23:00"), LocalTime.parse("23:15"), LocalTime.parse("23:30"), LocalTime.parse("23:45")
										);
		
		//inizializzo la data a quella attuale per non avere problemi di data nulla
		dataCliente.setValue(LocalDate.now());
		
		/**
		//inizializzazione delle colonne della tabella riepilogo ordini
		colOrario.setCellValueFactory(cellData -> cellData.getValue().getOrario().asObject());
		colIndirizzo.setCellValueFactory(cellData -> cellData.getValue().getIndirizzoProperty().asObject());
		colPizze.setCellValueFactory(cellData -> cellData.getValue().getElencoPizze());
		**/
		
	}
}
