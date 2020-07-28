package controller;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import dataAccessObject.OrdiniDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import model.Ordine;


public class ClienteController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="tabOrdini"
	private  TableView<Ordine> tabOrdini; // Value injected by FXMLLoader

	@FXML // fx:id="colNomeCliente"
	private TableColumn<Ordine, String> colNomeCliente; // Value injected by FXMLLoader

	@FXML // fx:id="colIndirizzo"
	private TableColumn<Ordine, String> colIndirizzo; // Value injected by FXMLLoader
	
	@FXML // fx:id="colData"
	private TableColumn<Ordine, LocalDate> colData; // Value injected by FXMLLoader
	
	@FXML // fx:id="colOrario"
	private TableColumn<Ordine, LocalTime> colOrario; // Value injected by FXMLLoader
	
	@FXML // fx:id="colTotale"
	private TableColumn<Ordine, Float> colTotale; // Value injected by FXMLLoader
	
	@FXML // fx:id="orarioCliente"
	private  ComboBox<LocalTime> orarioCliente; // Value injected by FXMLLoader
	
	@FXML // fx:id="txtNomeCliente"
	private  TextField txtNomeCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtTelefonoCliente"
	private TextField txtTelefonoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtIndirizzoCliente"
	private  TextField txtIndirizzoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="txtCivicoCliente"
	private TextField txtCivicoCliente; // Value injected by FXMLLoader

	@FXML // fx:id="dataCliente"
	private DatePicker dataCliente; // Value injected by FXMLLoader

	@FXML // fx:id="ClienteBackHome"
	private Button ClienteBackHome; // Value injected by FXMLLoader
	
	@FXML // fx:id="btnSelezionePizze"
	private Button btnSelezionePizze; // Value injected by FXMLLoader
	
	//formatter utilizzati per DATA e ORARIO
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");
	
    
	//Controlla se tutti i dati inseriti sono giusti e apre la la finestra di selezione delle pizze
	@FXML
	void btnPizzeAction(ActionEvent event) throws Exception {
		//variabile che controlla se tutti i dati inseriti soono giusti
		int flag = 0;
		
		System.out.println("Controllo dei dati inseriti riguardanti il Cliente");

		if (!(txtNomeCliente.getText().isEmpty())) {
			if (!(StringUtils.isAlphaSpace(txtNomeCliente.getText()))) {
				flag = 1;
				System.out.println("Nome Cliente NON valido");
				
				JOptionPane.showMessageDialog(null, "Errore inserimento NOME CLIENTE");
			}
		}
		else {
			txtNomeCliente.setText("Asporto");
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
			if (((dataCliente.getValue()).isEqual(LocalDate.now())) && (orarioCliente.getValue().isBefore(LocalTime.now()))) {
				flag = 1;
				System.out.println("Orario inserito NON valido");
				JOptionPane.showMessageDialog(null, "Errore inserimento ORARIO");			
			}
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

			
			OrdiniDAO.insertOrdine(dataCliente.getValue().format(formatoData), orarioCliente.getValue().format(formatoOra),0,txtNomeCliente.getText(),txtIndirizzoCliente.getText()+"  " + txtCivicoCliente.getText());
			System.out.println("APERTURA Finestra Scelta delle Pizze");
			WindowsManager.setPizza();
			
		}
	}
	
	

	 @FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() throws Exception, SQLException  {
		assert tabOrdini != null : "fx:id=\"tabOrdini\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colOrario != null : "fx:id=\"colonnaOrario\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colIndirizzo != null : "fx:id=\"colonnaIndirizzo\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert colData != null : "fx:id=\"colonnaPizze\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert orarioCliente != null : "fx:id=\"orarioCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtNomeCliente != null : "fx:id=\"txtNomeCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtTelefonoCliente != null : "fx:id=\"txtTelefonoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtIndirizzoCliente != null : "fx:id=\"txtIndirizzoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert txtCivicoCliente != null : "fx:id=\"txtCivicoCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert dataCliente != null : "fx:id=\"dataCliente\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert ClienteBackHome != null : "fx:id=\"ClienteBackHome\" was not injected: check your FXML file 'Cliente.fxml'.";
		assert btnSelezionePizze != null : "fx:id=\"ClientePizze\" was not injected: check your FXML file 'Cliente.fxml'.";
		
		
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
		
		ObservableList<Ordine> ordiniList = OrdiniDAO.getAllRecords();
		System.out.println(ordiniList.toString());
		
		//inizializzazione delle colonne della tabella riepilogo ordine	
				colNomeCliente.setCellValueFactory(cellData -> cellData.getValue().getNomeCliente());
				colIndirizzo.setCellValueFactory(cellData -> cellData.getValue().getIndirizzoProperty());
				//colOrario.setCellValueFactory(cellData -> cellData.getValue().getOrarioProperty().asObject());
				//colData.setCellValueFactory(cellData -> cellData.getValue().getDataProperty());
				colTotale.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
				populateTable(ordiniList);
	}
	
	
	 @FXML
	 void BackHome(ActionEvent event) throws Exception {
	    	System.out.println("Ritorno a finestra home");
	    	WindowsManager.start();
	 }
	
	 
	/**
	 * Popola la tabella degli ordini con tutti gli ordini presenti nel Database
	 * @param pizzaList
	 */	 
	private void populateTable(ObservableList<Ordine> ordineList) {
		tabOrdini.setItems(ordineList);
	}
	

	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Cliente.fxml"));
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene clienteScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());

		return clienteScene;
	}

}

