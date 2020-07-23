package controller;

import java.sql.SQLException;
import dataAccessObject.IngredienteDAO;
import dataAccessObject.PizzaDAO;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Screen;
import manager.WindowsManager;
import model.Ingrediente;
import model.Pizza;

public class PizzaController {
	
	static FloatProperty prezzoMod;
    
	static String bibita;
	
    @FXML // fx:id="txtCercaPizza"
    private TextField txtCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="btnModifica"
    private Button btnModifica; // Value injected by FXMLLoader

    @FXML // fx:id="GroupImpasto"
    private ToggleGroup GroupImpasto; // Value injected by FXMLLoader

    @FXML // fx:id="colPizza"
    private TableColumn<Pizza, String> colPizza; // Value injected by FXMLLoader

    @FXML // fx:id="colBibita"
    private TableColumn<Pizza, String> colBibita; // Value injected by FXMLLoader

    @FXML // fx:id="colPrezzo"
    private TableColumn<Pizza, Float> colPrezzo; // Value injected by FXMLLoader

    @FXML // fx:id="rdoIntegrale"
    private RadioButton rdoIntegrale; // Value injected by FXMLLoader

    @FXML // fx:id="colPrezzoSelezione"
    private TableColumn<Pizza, Float> colPrezzoSelezione; // Value injected by FXMLLoader

    @FXML // fx:id="tabCercaPizza"
    private TableView<Pizza> tabCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="rdoPomodoroSì"
    private RadioButton rdoPomodoroSì; // Value injected by FXMLLoader

    @FXML // fx:id="tabOrdine"
    private TableView<Pizza> tabOrdine; // Value injected by FXMLLoader

    @FXML // fx:id="chkDoppio"
    private CheckBox chkDoppio; // Value injected by FXMLLoader

    @FXML // fx:id="GroupPomodoro"
    private ToggleGroup GroupPomodoro; // Value injected by FXMLLoader

    @FXML // fx:id="btnAggiungi"
    private Button btnAggiungi; // Value injected by FXMLLoader

    @FXML // fx:id="rdoKamut"
    private RadioButton rdoKamut; // Value injected by FXMLLoader

    @FXML // fx:id="colPizzaSelezione"
    private TableColumn<Pizza, String> colPizzaSelezione; // Value injected by FXMLLoader

    @FXML // fx:id="rdoMozzarellaSì"
    private RadioButton rdoMozzarellaSì; // Value injected by FXMLLoader

    @FXML // fx:id="rdoPomodoroNo"
    private RadioButton rdoPomodoroNo; // Value injected by FXMLLoader

    @FXML // fx:id="rdoNormale"
    private RadioButton rdoNormale; // Value injected by FXMLLoader

    @FXML // fx:id="GroupMozzarella"
    private ToggleGroup GroupMozzarella; // Value injected by FXMLLoader

    @FXML // fx:id="rdoMozzarellaNo"
    private RadioButton rdoMozzarellaNo; // Value injected by FXMLLoader
   
    @FXML
    private CheckBox chkProsciuttoCotto;
    
    @FXML
    private CheckBox chkDiavola;
    
    @FXML
    private CheckBox chkTuaMamma;
    
    @FXML
    private CheckBox chkWustrler;
    
    @FXML
    private Label PrezzoModifica;
    
    @FXML // fx:id="rdoAcqua"
    private RadioButton rdoAcqua; // Value injected by FXMLLoader
    
    @FXML // fx:id="rdoCocaCola"
    private RadioButton rdoCocaCola; // Value injected by FXMLLoader

    @FXML // fx:id="rdoFanta"
    private RadioButton rdoFanta; // Value injected by FXMLLoader
    
    @FXML // fx:id="rdoBirra1"
    private RadioButton rdoBirra1; // Value injected by FXMLLoader
    
    @FXML // fx:id="rdoBirra2"
    private RadioButton rdoBirra2; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtCercaIngrediente"
    private TextField txtCercaIngrediente; // Value injected by FXMLLoader
    
    @FXML // fx:id="tabCercaIngrediente"
    private TableView<Ingrediente> tabCercaIngrediente; // Value injected by FXMLLoader
    
    @FXML // fx:id="colIngredienteSelezione"
    private TableColumn<Ingrediente, String> colIngredienteSelezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="colCostoSelezione"
    private TableColumn<Pizza, Float> colCostoSelezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="colBibitaSelezione"
    private TableColumn<Pizza, String> colBibitaSelezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCliente"
    private Button btnBackToCliente ; // Value injected by FXMLLoader
    
    
    
    
    /**
     * Action di Bottone Aggiungi Pizza:
     * inserisce la pizza selezionata dalla tabella nella tabella Ordine
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	@FXML
	void btnAggiungiPizzaAction(ActionEvent event) throws ClassNotFoundException, SQLException {
		//System.out.println("Bibita = " + bibita.getValue());
		System.out.println("Aggiunta Pizza");
		Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		if (pizzaSelezionata == null) {
			System.out.println("Nessuna Pizza selezionata");
		} else {
			
			StringProperty nomePizzaSelezionata = pizzaSelezionata.getNomePizzaProperty();
			FloatProperty prezzoPizzaSelezionata = pizzaSelezionata.getPrezzoProperty();
			System.out.println("Nome Pizza selezionata = " + nomePizzaSelezionata.get());
			System.out.println("Prezzo Pizza selezionata = " + prezzoPizzaSelezionata.get());
		
			Pizza pizzaSelected = new Pizza(pizzaSelezionata.getNomePizzaProperty(), prezzoMod);
			
			if(rdoAcqua.isSelected()) {
				System.out.println("Bibita selezionata = Acqua");
				bibita="Acqua";
				
			}

		
			if(rdoCocaCola.isSelected()) {
				System.out.println("Bibita selezionata = CocaCola");
				bibita=rdoCocaCola.getText();
			}
			
			if(rdoFanta.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita=rdoFanta.getText();
			}
			if(rdoBirra1.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita=rdoBirra1.getText();
			}
			
			if(rdoBirra2.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita=rdoBirra2.getText();
			}
			
			System.out.println("Bibita selezionata = " +bibita);
			
			
			
			tabOrdine.getItems().add(pizzaSelected);
		}
	}
	
	/**
	 * Resetta tutti i RadioButton e CheckButton Default
	 */
	
	public void clearChkRdo() { 
		rdoPomodoroNo.setSelected(true);
		rdoMozzarellaNo.setSelected(true);
		rdoCocaCola.setSelected(true);
		chkProsciuttoCotto.setSelected(false);
		chkWustrler.setSelected(false);
		chkTuaMamma.setSelected(false);
		chkDiavola.setSelected(false);  
	}
	
	
	/**
	 * Action performed on the button to go back on client window
	 */
	
	@FXML
    void BackToCliente(ActionEvent event) throws Exception {
    	System.out.println("Ritorno a finestra cliente");
    	WindowsManager.setCliente();
    }
	

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() throws Exception, SQLException {    	
		assert tabOrdine != null : "fx:id=\"tabOrdine\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert tabCercaPizza != null : "fx:id=\"tabPizze\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert txtCercaPizza != null : "fx:id=\"txtCercaPizza\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert tabCercaPizza != null : "fx:id=\"tabCercaPizza\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert btnModifica != null : "fx:id=\"btnModifica\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert chkDoppio != null : "fx:id=\"chkDoppio\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoNormale != null : "fx:id=\"rdoNormale\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoIntegrale != null : "fx:id=\"rdoIntegrale\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoKamut != null : "fx:id=\"rdoKamut\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoMozzarellaSì != null : "fx:id=\"rdoMozzarellaSì\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoMozzarellaNo != null : "fx:id=\"rdoMozzarellaNo\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoPomodoroSì != null : "fx:id=\"rdoPomodoroSì\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert rdoPomodoroNo != null : "fx:id=\"rdoPomodoroNo\" was not injected: check your FXML file 'Pizza.fxml'.";
		
		//inizializzazione delle colonne della tabella riepilogo ordine
		colPizza.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		
		
		//inizializzazione delle colonne della tabella di selezione della pizza
		colPizzaSelezione.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzoSelezione.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		ObservableList<Pizza> pizzaList = PizzaDAO.getAllRecords();
		populateTable(pizzaList);
		
	/*
		//inizializzazione delle colonne della tabella di selezione degli ingredienti
		colIngredienteSelezione.setCellValueFactory(cellData -> cellData.getValue().getNomeIngredienteProperty());
		colCostoSelezione.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		ObservableList<Ingrediente> ingredienteList = IngredienteDAO.getAllRecords();
		populateTableIngredienti(ingredienteList);
	*/	
		
		/**
		 * Metodo che ad ogni cambiamento del testo inserito nella textBox CercaPizza
		 * cerca nel mio DataBase le pizze che corrispondono ai caratteri inseriti
		 */
		txtCercaPizza.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue){
				// this will run whenever text is changed
				System.out.println("Ricevuto Cambiamento nella Ricerca Pizze");
				try {
					ObservableList<Pizza> pizzaList = PizzaDAO.getAllRecordsAggiorna(newValue);
					populateTable(pizzaList);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		/**
		 * Metodo che ad ogni cambiamento del testo inserito nella textBox CercaIngrediente
		 * cerca nel mio DataBase gli ingredienti che corrispondono ai caratteri inseriti
		 */
		txtCercaIngrediente.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue){
				// this will run whenever text is changed
				System.out.println("Ricevuto Cambiamento nella Ricerca Ingredienti");
				try {
					ObservableList<Ingrediente> ingredienteList = IngredienteDAO.getAllRecordsAggiorna(newValue);
					populateTableIngredienti(ingredienteList);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		/*
		 * Metodo che cambia il Form di selezione degli ingredienti in base agli ingredienti letti nel DataBase
		 * in base al nome della pizza che viene selezionata dalla Tabella di selezione
		 */
		
		tabCercaPizza.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	System.out.println("Selezione Pizza Valida");
		    	
		    	//Qui devo selezionare i rdoButton in base alla pizza selezionata
		    	//creo un metodo per selezionare gli ingredienti in base al nome della pizza
		    //	Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		  //  	Pizza pizzaSelected = new Pizza(pizzaSelezionata.getNomePizzaProperty(), pizzaSelezionata.getPrezzoProperty(), 
		   // 			pizzaSelezionata.getIngredientiProperty());
		    //	String ingredienti = pizzaSelected.getIngredienti();
		   // 	clearChkRdo();
		    	//ingredienti = stringa che contiene gli ingredienti, separati da un '/'
		   // 	System.out.println(ingredienti);
		   // 	prezzoMod =pizzaSelezionata.getPrezzoProperty();
		    	//ricavo i singoli ingredienti
		  //  	Scanner s = new Scanner(ingredienti);
		//    	s.useDelimiter("/");
		  /*  	
		    	//per ogni ingrediente contenuto nella stringa letta si provvede a Settare i vari Radio e Check Button
		    	 while(s.hasNext()){
		    		 String ingrediente = s.next();
		    		 
		    		 if (ingrediente.equals("Mozzarella")) rdoMozzarellaSì.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Pomodoro")) rdoPomodoroSì.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Diavola")) chkDiavola.setSelected(true);
		    		 
		    		 if (ingrediente.equals("TuaMamma")) chkTuaMamma.setSelected(true);
		    		
		    		 if (ingrediente.equals("Wustrler")) chkWustrler.setSelected(true);
		    		 
		    		 if (ingrediente.equals("ProsciuttoCotto")) chkProsciuttoCotto.setSelected(true);
		    		 
		    		 System.out.println(ingrediente);
		    	 }   
		    	 
		    	 //chiusura dello Scanner
		    	
		    	 s.close();
		    	 
		    	 
		    	 System.out.println("Prezzo pizza selezionata PRIMA cambiamento: " + prezzoMod.toString());
		    	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
		    	 
		    	 /**
		    	  * Metodo per cambiare il prezzo in base alla selezione di una diversa CheckBox
		    	  * AGGIUNGO se ne seleziono di nuove
		    	  * TOLGO se tolgo la selezione di qualcuna
		    	  */
		    	 /*
		    	 chkDiavola.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    		    @Override
		    		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    		    	if (!oldValue)
		    		    		System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelected.getPrezzoProperty().add(0.5).get());
		    		    	else 
		    		    		System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelected.getPrezzoProperty().add(-0.5).get());
		    		    }
		    	 });
		    	 */
		    	 
		    	 
		    	//Aggiunta sovraprezzo per ingredienti aggiuntivi
		    	 
		    	 EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
		    		    @Override
		    		    public void handle(ActionEvent event) {
		    		        if (event.getSource() instanceof CheckBox) {
		    		            CheckBox chk = (CheckBox) event.getSource();
		    		            System.out.println("Action performed on checkbox " + chk.getText());
		    		            if (chk.isSelected()) {
		    		            	 ;
		    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + prezzoMod.get());
		    		            	 prezzoMod.set(prezzoMod.get()+ (float)0.5);
		    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + prezzoMod.get());
		    		            	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
		    		            } else{
		    		            	
		    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + prezzoMod.get());
		    		            	 prezzoMod.set(prezzoMod.get()- (float)0.5);
		    		            	// PrezzoModifica.setText("" + model.Pizza.getPrezzoModifica());
		    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + prezzoMod.get());
		    		            
		    		            	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
		    		            }
		    		        }
		    		    }
		    		};

		    		chkDiavola.setOnAction(eh);
		    		chkProsciuttoCotto.setOnAction(eh);
		    		chkTuaMamma.setOnAction(eh);
		    		chkWustrler.setOnAction(eh);
		    		
		    		

		    		
		  		
		    		//Aggiunta sovraprezzo per l'impasto doppio
		    		
		    		 EventHandler<ActionEvent> dp = new EventHandler<ActionEvent>() {
			    		    @Override
			    		    public void handle(ActionEvent event) {
			    		        if (event.getSource() instanceof CheckBox) {
			    		            CheckBox chk = (CheckBox) event.getSource();
			    		            System.out.println("Action performed on checkbox Doppio ");
			    		            if (chk.isSelected()) {
			    		            	 
			    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + prezzoMod.get());
			    		            	 prezzoMod.set(prezzoMod.get()+ (float)1);
			    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + prezzoMod.get());
			    		            	
			    		            	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
			    		            } else{
			    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + prezzoMod.get());
			    		            	 prezzoMod.set(prezzoMod.get()- (float)1);
			    		            	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
			    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + prezzoMod.get());
			    		            }
			    		        }
			    		    }
			    		};

			    		chkDoppio.setOnAction(dp);
		    		
		    }
		    
		    else {
		    	System.out.println("Selezione Pizza NON Valida");
		    }
		    		 
		});
		
	}
	
	
	


	/**
	 * Popola la tabella selezione pizze con tutte le pizze presenti nel Database
	 * @param pizzaList
	 */
	private void populateTable(ObservableList<Pizza> pizzaList) {
		tabCercaPizza.setItems(pizzaList);
	}

	
	/**
	 * Popola la tabella selezione ingredienti con tutti gli ingredienti presenti nel Database
	 * @param ingredientiList
	 */
	private void populateTableIngredienti(ObservableList<Ingrediente> ingredienteList) {
		tabCercaIngrediente.setItems(ingredienteList);
	}
	
	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Pizza.fxml"));
		
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene pizzaScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());
		
		return pizzaScene;
	}
}

