package controller;

import java.sql.SQLException;
import java.util.Scanner;
import dataAccessObject.IngredienteDAO;
import dataAccessObject.PizzaDAO;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
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
import model.Pizza;

public class PizzaController {
    @FXML // fx:id="txtCercaPizza"
    private TextField txtCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="btnModifica"
    private Button btnModifica; // Value injected by FXMLLoader

    @FXML // fx:id="GroupImpasto"
    private ToggleGroup GroupImpasto; // Value injected by FXMLLoader

    @FXML // fx:id="colPizza"
    private TableColumn<Pizza, String> colPizza; // Value injected by FXMLLoader

    @FXML // fx:id="colIngredienti"
    private TableColumn<Pizza, String> colIngredienti; // Value injected by FXMLLoader
    
    @FXML // fx:id="colBibita"
    private TableColumn<Pizza, String> colBibita; // Value injected by FXMLLoader

    @FXML // fx:id="colPrezzo"
    private TableColumn<Pizza, Float> colPrezzo; // Value injected by FXMLLoader

    @FXML // fx:id="rdoIntegrale"
    private RadioButton rdoIntegrale; // Value injected by FXMLLoader

    @FXML // fx:id="tabCercaPizza"
    private TableView<Pizza> tabCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="tabOrdine"
    private TableView<Pizza> tabOrdine; // Value injected by FXMLLoader

    @FXML // fx:id="chkDoppio"
    private CheckBox chkDoppio; // Value injected by FXMLLoader

    @FXML // fx:id="btnAggiungi"
    private Button btnAggiungi; // Value injected by FXMLLoader

    @FXML // fx:id="rdoKamut"
    private RadioButton rdoKamut; // Value injected by FXMLLoader
   
    @FXML // fx:id="rdoNormale"
    private RadioButton rdoNormale; // Value injected by FXMLLoader

    @FXML // fx:id="chkMozzarella"
    private CheckBox chkMozzarella; // Value injected by FXMLLoader
   
    @FXML // fx:id="chkPomodoro"
    private CheckBox chkPomodoro; // Value injected by FXMLLoader
      
    @FXML // fx:id="colPizzaSelezione"
    private TableColumn<Pizza, String> colPizzaSelezione; // Value injected by FXMLLoader

    @FXML // fx:id="colIngredientiSelezione"
    private TableColumn<Pizza, String> colIngredientiSelezione; // Value injected by FXMLLoader
   
    @FXML // fx:id="colPrezzoSelezione"
    private TableColumn<Pizza, Float> colPrezzoSelezione; // Value injected by FXMLLoader
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
    
    @FXML // fx:id="prezzoTotale"
    private Label prezzoTotale;
    
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
      
    @FXML // fx:id="colCostoSelezione"
    private TableColumn<Pizza, Float> colCostoSelezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="colBibitaSelezione"
    private TableColumn<Pizza, String> colBibitaSelezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCliente"
    private Button btnBackToCliente ; // Value injected by FXMLLoader
    
    FloatProperty prezzoMod= new SimpleFloatProperty();
    
    StringProperty bibita=new SimpleStringProperty();
	
	float sovraprezzo=0;
	
    
    /**
     * Action di Bottone Aggiungi Pizza:
     * inserisce la pizza selezionata dalla tabella nella tabella Ordine
     * @param event
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	@FXML
	void btnAggiungiPizzaAction(ActionEvent event) throws ClassNotFoundException, SQLException {
		System.out.println("Aggiunta Pizza");
		Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		if (pizzaSelezionata == null) {
			System.out.println("Nessuna Pizza selezionata");
		} else {
			StringProperty nomePizzaSelezionata = pizzaSelezionata.getNomePizzaProperty();
			FloatProperty prezzoPizzaSelezionata = pizzaSelezionata.getPrezzoProperty();
			StringProperty ingredientiPizzaSelezionata = pizzaSelezionata.getIngredientiPizzaProperty();
			
			System.out.println("Nome Pizza selezionata = " + nomePizzaSelezionata.get());
			System.out.println("Prezzo Pizza selezionata = " + prezzoPizzaSelezionata.get());
			System.out.println("Ingredienti Pizza selezionata = " + ingredientiPizzaSelezionata.get());
			
			
			if(rdoAcqua.isSelected()) {
				System.out.println("Bibita selezionata = Acqua");
				bibita.setValue("Acqua");
			}
		
			if(rdoCocaCola.isSelected()) {
				bibita.setValue(rdoCocaCola.getText());
				System.out.println("Bibita selezionata = CocaCola");
			}
			
			if(rdoFanta.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita.setValue(rdoFanta.getText());
			}
			
			if(rdoBirra1.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita.setValue(rdoBirra1.getText());
			}
			
			if(rdoBirra2.isSelected()) {
				System.out.println("Bibita selezionata = Fanta");
				bibita.setValue(rdoBirra2.getText());
			}
			
			System.out.println("Bibita selezionata = " +bibita.toString());
			
			Pizza pizzaSelected = new Pizza(nomePizzaSelezionata,prezzoMod,ingredientiPizzaSelezionata,bibita );
			tabOrdine.getItems().add(pizzaSelected);
			
		}
	}
	
	
	
	/**
	 * Resetta tutti i RadioButton e CheckButton Default
	 */
	public void clearChkRdo() { 
		chkPomodoro.setSelected(false);
		chkMozzarella.setSelected(false);
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
		assert chkMozzarella != null : "fx:id=\"chkMozzarella\" was not injected: check your FXML file 'Pizza.fxml'.";
		assert chkPomodoro != null : "fx:id=\"chkPomodoro\" was not injected: check your FXML file 'Pizza.fxml'.";
	
		
		//inizializzazione delle colonne della tabella riepilogo ordine
		colPizza.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		colIngredienti.setCellValueFactory(cellData -> cellData.getValue().getIngredientiPizzaProperty());
		colBibita.setCellValueFactory(cellData -> cellData.getValue().getBibitaProperty());
		
		//inizializzazione delle colonne della tabella di selezione della pizza
		colPizzaSelezione.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzoSelezione.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		colIngredientiSelezione.setCellValueFactory(cellData -> cellData.getValue().getIngredientiPizzaProperty());
		ObservableList<Pizza> pizzaList = PizzaDAO.getAllRecords();
		populateTable(pizzaList);
		
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
		/*txtCercaIngrediente.textProperty().addListener(new ChangeListener<String>() {
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
		
		*/
		/*
		 * Metodo che cambia il Form di selezione degli ingredienti in base agli ingredienti letti nel DataBase
		 * in base al nome della pizza che viene selezionata dalla Tabella di selezione
		 */
		
		tabCercaPizza.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	System.out.println("Selezione Pizza Valida");
		    	
		    	//Qui devo selezionare i rdoButton in base alla pizza selezionata
		    	//creo un metodo per selezionare gli ingredienti in base al nome della pizza
		 
		    	Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		    	Pizza pizzaSelected = new Pizza(pizzaSelezionata.getNomePizzaProperty(), pizzaSelezionata.getPrezzoProperty(),pizzaSelezionata.getIngredientiPizzaProperty());
		    	String ingredienti = pizzaSelected.getIngredienti();
		    	prezzoMod=pizzaSelected.getPrezzoProperty();
		    	clearChkRdo();
		    
		    	//ingredienti = stringa che contiene gli ingredienti, separati da un '/'
		    	System.out.println("Ingredienti Pizza" + pizzaSelezionata.getNomePizzaProperty());
		    	System.out.println(ingredienti);
		    	
		    	//ricavo i singoli ingredienti
		    	Scanner s = new Scanner(ingredienti);
		    	s.useDelimiter("/");
		  	
		    	//per ogni ingrediente contenuto nella stringa letta si provvede a Settare i vari Radio e Check Button
		    	 while(s.hasNext()){
		    		 String ingrediente = s.next();
		    		 
		    		 if (ingrediente.equals("Mozzarella")) chkMozzarella.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Pomodoro")) chkPomodoro.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Diavola")) chkDiavola.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Prosciutto Crudo")) chkTuaMamma.setSelected(true);
		    		
		    		 if (ingrediente.equals("Wurstel")) chkWustrler.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Prosciutto Cotto")) chkProsciuttoCotto.setSelected(true);
		    		 
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
		    	 
		    	 chkDiavola.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    		    @Override
		    		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    		    	if (!oldValue)
		    		    		System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + prezzoMod);
		    		    	else 
		    		    		System.out.println("Prezzo Pizza selezionata DOPO cambiamento: "+prezzoMod );
		    		    }
		    	 });
		    	 
		    	 
		    	//Aggiunta sovraprezzo per ingredienti aggiuntivi
		    	
		    	 EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
		    		    @Override
		    		    public void handle(ActionEvent event) {
		    		        if (event.getSource() instanceof CheckBox) {
		    		            CheckBox chk = (CheckBox) event.getSource();
		    		            System.out.println("Action performed on checkbox " + chk.getText());
		    		            
		    		     
		    		            // In sovraprezzo ho il costo di ogni ingrediente aggiuntivo
		    		            try {
		    		            	 System.out.println("Nome dell'ingrediente " +chk.getText());
									 sovraprezzo =IngredienteDAO.getPrezzoIngrediente(chk.getText());
		    		            	 System.out.println(chk.getText()+"  - Il prezzo dell'ingrediente e' " +sovraprezzo);

								} catch (ClassNotFoundException | SQLException e) {
		    		            	 System.out.println("Errore nel trovare il prezzo dell'ingrediente");
									e.printStackTrace();
								}
		    		          
		    		           //Se il bottone viene selezionato si aggiunge il prezzo
		    		            
		    		            if (chk.isSelected()) {
		    		            	 System.out.println("Prezzo Pizza PRIMA cambiamento: " + prezzoMod.get());
		    		            	 System.out.println("INGREDIENTI PRIMA cambiamento: " + pizzaSelected.getIngredienti());
		    		            	 prezzoMod.set(prezzoMod.get()+ sovraprezzo);
		    		            	 System.out.println("Prezzo Pizza DOPO cambiamento: " + prezzoMod.get());
		    		            	 PrezzoModifica.setText(String.valueOf(prezzoMod.get()));
		    		            	 pizzaSelected.addIngrediente( chk.getText());
		    		            	 System.out.println("ingredienti dopo della modifica: " + pizzaSelected.getIngredienti());
		    		            } else {      	
		    		            	 System.out.println("Prezzo Pizza selezionata PRIMA cambiamento: " + prezzoMod.get());
		    		            	 prezzoMod.set(prezzoMod.get()- sovraprezzo);
		    		            	 
		    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelected.getPrezzo());
		    		            	 
		    		            	System.out.println("INGREDIENTI PRIMA cambiamento: " + pizzaSelected.getIngredienti());
		    		            	 pizzaSelected.removeIngrediente( chk.getText());
		    		            	 
		    		            	  
		    		            //	 pizzaSelected.setIngredientiPizza(ing);
		    		            	 System.out.println("ingredienti dopo della modifica: " + pizzaSelected.getIngredienti());
		    		            	 
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
		    		chkMozzarella.setOnAction(eh);
		    		chkPomodoro.setOnAction(eh);
		    		

		    		
		  		
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
	
	/*
	
	private void populateTableIngredienti(ObservableList<Ingrediente> ingredienteList) {
		tabCercaIngrediente.setItems(ingredienteList);
	}
	*/
	
	
	
	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Pizza.fxml"));
		
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene pizzaScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());
		
		return pizzaScene;
	}
	
	
}

