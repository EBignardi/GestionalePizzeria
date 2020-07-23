package controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import dataAccessObject.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
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

	@FXML // fx:id="ClienteBackHome"
	private Button ClienteBackHome; // Value injected by FXMLLoader
	
	//formatter utilizzati per DATA e ORARIO
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");

	@FXML
	void buttonPizzeAction(ActionEvent event) throws Exception {
		//variabile che controlla se tutti i dati inseriti soono giusti
		int flag = 0;

		System.out.println("Controllo dei dati inseriti riguardanti il Cliente");

		if (!(txtNomeCliente.getText().isEmpty())) {
			if (!(StringUtils.isAlpha(txtNomeCliente.getText()))) {
				flag = 1;
				System.out.println("Nome Cliente NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento NOME CLIENTE");
			}
		}

		if (!(txtTelefonoCliente.getText().isEmpty())) {
			if((!(StringUtils.isNumeric(txtTelefonoCliente.getText()))) || (txtTelefonoCliente.getText().length() > 11)) {
				flag = 1;
				System.out.println("Numero Telefono NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento TELEFONO");
			}
		}

		if (!(txtIndirizzoCliente.getText().isEmpty())) {
			if(!(StringUtils.isAlphaSpace(txtIndirizzoCliente.getText()))) {
				flag = 1;
				System.out.println("Indirizzo NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento INDIRIZZO");
			}
		}

		if (!(txtCivicoCliente.getText().isEmpty())) {
			if(!(StringUtils.isNumeric(txtCivicoCliente.getText()))) {
				flag = 1;
				System.out.println("Civico NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento CIVICO");
			}
		}

		if (((dataCliente.getValue().format(formatoData)).compareTo(LocalDate.now().format(formatoData)) < 0)) {
			flag = 1;
			System.out.println("Data inserita NON valida");
			JOptionPane.showMessageDialog(null, "Errore inserimento DATA");
		}

		if (orarioCliente.getValue() != null) {
			//Nella data odierna non posso prendere ordini con una data inferiore a quella attuale
		/*	if (((dataCliente.getValue()).isEqual(LocalDate.now())) && (orarioCliente.getValue().isBefore(LocalTime.now()))) {
				flag = 1;
				System.out.println("Orario inserito NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento ORARIO");			
			}*/
		} else {
			System.out.println("Orario NON inserito, setto quello corrente");
			orarioCliente.setValue(LocalTime.now());
		}

		if (flag == 0) {
			System.out.println("Salvataggio dei dati relativi al cliente: \n" + 
					"Nome: " + txtNomeCliente.getText() + "\n" + 
					"Telefono: " + txtTelefonoCliente.getText() + "\n" +
					"Indirizzo: " + txtIndirizzoCliente.getText() + "\n" +
					"Civico: " + txtCivicoCliente.getText() + "\n" +
					"Data Ordine: " + dataCliente.getValue().format(formatoData) + "\n" + 
					"Orario Ordine: " + orarioCliente.getValue().format(formatoOra));

			//inserisco i dati nel DataBase nella Tabella Cliente
			ClienteDAO.insertCliente(txtNomeCliente.getText(), txtTelefonoCliente.getText(), txtIndirizzoCliente.getText(),  
					txtCivicoCliente.getText());
//dataCliente.getValue().format(formatoData), orarioCliente.getValue().format(formatoOra)
			System.out.println("APERTURA Finestra Scelta delle Pizze");
			WindowsManager.setPizza();
		}

	}
	
	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Cliente.fxml"));
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene clienteScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());

		return clienteScene;
	}
	
	 @FXML
	    void BackHome(ActionEvent event) throws Exception {
	    	System.out.println("Ritorno a finestra home");
	    	WindowsManager.start();
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
