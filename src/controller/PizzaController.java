package controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dataAccessObject.IngredienteDAO;
import dataAccessObject.OrdiniDAO;
import dataAccessObject.PizzaDAO;
import javafx.beans.property.FloatProperty;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import manager.WindowsManager;
import model.Pizza;

public class PizzaController {
    @FXML // fx:id="txtCercaPizza"
    private TextField txtCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="btnModifica"
    private Button btnModifica; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnOrdina"
    private Button btnOrdina; // Value injected by FXMLLoader

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
    private TableView<Pizza> tabCercaPizza; // Value injected by FXMLLoader //Tabella alto dx

    @FXML // fx:id="tabOrdine"
    private TableView<Pizza> tabOrdine; // Value injected by FXMLLoader //sx
 
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
   
    @FXML	// fx:id="chkProsciuttoCotto"
    private CheckBox chkProsciuttoCotto;	// Value injected by FXMLLoader
    
    @FXML	// fx:id="chkDiavola"
    private CheckBox chkDiavola;	// Value injected by FXMLLoader
    
    @FXML	// fx:id="chkProsciuttoCrudo"
    private CheckBox chkProsciuttoCrudo;	// Value injected by FXMLLoader
    
    @FXML	// fx:id="chkWurstel"
    private CheckBox chkWustrler;	// Value injected by FXMLLoader
    
    @FXML	// fx:id="Prezzo Modifica"
    private Label PrezzoModifica;	// Value injected by FXMLLoader
    
    @FXML // fx:id="prezzoTotale"
    private Label prezzoTotale; 	// Value injected by FXMLLoader
    
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
    
    @FXML // fx:id="visibleGrid"
    private GridPane visibleGrid; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCliente"
    private Button btnBackToCliente ; // Value injected by FXMLLoader 
    
	List<Pizza> listaPizze = new ArrayList<Pizza>(); //Lista delle pizze inserite nell'ordine
    
	
	
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
			StringProperty tempSelezionata = new SimpleStringProperty("CocaCola");
			
			String nomePizza = nomePizzaSelezionata.get();
			Float prezzoPizza = prezzoPizzaSelezionata.get();
			String ingredientiPizza = ingredientiPizzaSelezionata.get();
			String temp = tempSelezionata.get();
			
			System.out.println("Nome Pizza selezionata = " + nomePizza);
			System.out.println("Prezzo Pizza selezionata = " + prezzoPizza);
			System.out.println("Ingredienti Pizza selezionata = " + ingredientiPizza);
			System.out.println("Bibita Pizza selezionata = " + temp);
				
			Pizza pizz = new Pizza();
			pizz.setNomePizza(nomePizza);
			pizz.setPrezzo(prezzoPizza);
			pizz.setIngredientiPizza(ingredientiPizza);
			pizz.setBibitaPizza(temp);
			
			System.out.println("Pizza Creata");
			
			listaPizze.add(pizz);
			int numeroPizza=listaPizze.size();
			tabOrdine.getItems().add(listaPizze.get(numeroPizza-1));
			tabCercaPizza.getSelectionModel().clearSelection();
			aggiornaPrezzoTot();
			System.out.println("Numero delle pizza nell'ordine e'" +numeroPizza);
		}
		
	}
	
	
	/**
     * Action di Bottone Aggiungi Ordine:
     * inserisce l'ordine nel Database
     * @param event
	 * @throws Exception 
     */
	@FXML
	void btnAggiungiOrdine(ActionEvent event) throws Exception {
		float prezzoTot = aggiornaPrezzoTot();
		System.out.println("Aggiunta Ordine, con prezzo Totale = "+ prezzoTot);
		OrdiniDAO.insertPrezzoUltimoOrdine(prezzoTot);
		System.out.println("Ritorno a finestra cliente");
    	WindowsManager.setCliente();
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
		chkProsciuttoCrudo.setSelected(false);
		chkDiavola.setSelected(false);  
		chkDoppio.setSelected(false);
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
				System.out.println("Ricevuto Cambiamento nella Ricerca Pizze");
				try {
					ObservableList<Pizza> pizzaList = PizzaDAO.getAllRecordsAggiorna(newValue);
					populateTable(pizzaList);
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println("Errore aggiornamento tabella cercaPizza");
					e.printStackTrace();
				}
			}
		});
		
		

		/*
		 * Metodo che cambia il Form di selezione degli ingredienti in base agli ingredienti letti nel DataBase
		 * in base al nome della pizza che viene selezionata dalla Tabella di selezione
		 */
		tabOrdine.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	
		    	visibleGrid.setVisible(true);;
		    	System.out.println("Selezione Pizza Valida");
		    	
		    	//Qui devo selezionare i rdoButton in base alla pizza selezionata
		    	//creo un metodo per selezionare gli ingredienti in base al nome della pizza
		    	
		    	int numeroSel=tabOrdine.getSelectionModel().getSelectedIndex();
		    	Pizza pizzaSelezionata = listaPizze.get(numeroSel);
		    	System.out.println("SELEZIONE Pizza Valida "+numeroSel);
		    	String ingredienti = pizzaSelezionata.getIngredienti();
		    	System.out.println(ingredienti);
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
		    		 
		    		 if (ingrediente.equals("Prosciutto Crudo")) chkProsciuttoCrudo.setSelected(true);
		    		
		    		 if (ingrediente.equals("Wurstel")) chkWustrler.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Prosciutto Cotto")) chkProsciuttoCotto.setSelected(true);
		    		 
		    		 System.out.println(ingrediente);
		    	 }   
		    	 //chiusura dello Scanner
		    	 s.close();
		      
		    	 
		    	 System.out.println("Prezzo pizza selezionata PRIMA cambiamento: " + pizzaSelezionata.getPrezzo());
		    	 PrezzoModifica.setText(String.valueOf(pizzaSelezionata.getPrezzo()));
		    	 
		    	 /**
		    	  * Metodo per cambiare il prezzo in base alla selezione di una diversa CheckBox
		    	  * AGGIUNGO se ne seleziono di nuove
		    	  * TOLGO se tolgo la selezione di qualcuna
		    	  */
		    	 EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
		    		    @Override
		    		    
		    		    public void handle(ActionEvent event) {
		    		    	Float sovraprezzo=null;
		    		        if (event.getSource() instanceof CheckBox) {
		    		            CheckBox chk = (CheckBox) event.getSource();
		    		            System.out.println("Action performed on checkbox " + chk.getText());
		    		            
		    		     
		    		            // In sovraprezzo ho il costo di ogni ingrediente aggiuntivo letto dal database
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
		    		            	 System.out.println("Prezzo Pizza PRIMA cambiamento: " + pizzaSelezionata.getPrezzo());
		    		            	 System.out.println("INGREDIENTI PRIMA cambiamento: " + pizzaSelezionata.getIngredienti());
		    		            	 pizzaSelezionata.setPrezzo(pizzaSelezionata.getPrezzo()+sovraprezzo);
		    		            	 aggiornaPrezzoTot();
		    		            	 System.out.println("Prezzo Pizza DOPO cambiamento: " + pizzaSelezionata.getPrezzo());
		    		            	 PrezzoModifica.setText(String.valueOf(pizzaSelezionata.getPrezzo()));
		    		            	 aggiornaPrezzoTot();
		    		            	 pizzaSelezionata.addIngrediente( chk.getText());
		    		            	 System.out.println("ingredienti dopo della modifica: " + pizzaSelezionata.getIngredienti());
		    		            } else {      	
		    		            	 System.out.println("Prezzo Pizza selezionata PRIMA cambiamento: " + pizzaSelezionata.getPrezzo());
		    		            	 pizzaSelezionata.setPrezzo(pizzaSelezionata.getPrezzo() - sovraprezzo);
		    		            	 aggiornaPrezzoTot();
		    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelezionata.getPrezzo());
		    		            	 System.out.println("INGREDIENTI PRIMA cambiamento: " + pizzaSelezionata.getIngredienti());
		    		            	 pizzaSelezionata.removeIngrediente( chk.getText());
		    		            	 System.out.println("ingredienti dopo della modifica: " + pizzaSelezionata.getIngredienti());
		    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelezionata.getPrezzo());
		    		            	 aggiornaPrezzoTot();
		    		            	 PrezzoModifica.setText(String.valueOf(pizzaSelezionata.getPrezzo()));
		    		            }
		    		        }
		    		    }
		    		};

		    		chkDiavola.setOnAction(eh);
		    		chkProsciuttoCotto.setOnAction(eh);
		    		chkProsciuttoCrudo.setOnAction(eh);
		    		chkWustrler.setOnAction(eh);
		    		chkMozzarella.setOnAction(eh);
		    		chkPomodoro.setOnAction(eh);
		    		

		    		
		    		//Seleziona Bibita in base al rdo selezionato
			    	 EventHandler<ActionEvent> bib = new EventHandler<ActionEvent>() {
			    		    @Override
			    		    public void handle(ActionEvent event) {
			    		        if (event.getSource() instanceof RadioButton) {
			    		            RadioButton rdo = (RadioButton) event.getSource();
			    		            System.out.println("Action performed on checkbox " + rdo.getText());
			    		            
			    		       
			    		           //Seleziono la bibita
			    					StringProperty bibita=new SimpleStringProperty();
			    					
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
			    					
			    					pizzaSelezionata.setBibitaPizza(bibita.get());
			    		            
			    		        }
			    		    }
			    		};

			    		rdoCocaCola.setOnAction(bib);
			    		rdoAcqua.setOnAction(bib);
			    		rdoBirra1.setOnAction(bib);
			    		rdoFanta.setOnAction(bib);
			    		rdoBirra2.setOnAction(bib);
		    		
		  		
		    		//Aggiunta sovraprezzo per l'impasto doppio in base al checkBox 
		    		 EventHandler<ActionEvent> dp = new EventHandler<ActionEvent>() {
			    		    @Override
			    		    public void handle(ActionEvent event) {
			    		        if (event.getSource() instanceof CheckBox) {
			    		            CheckBox chk = (CheckBox) event.getSource();
			    		            System.out.println("Action performed on checkbox Doppio ");
			    		            if (chk.isSelected()) { 
			    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + pizzaSelezionata.getPrezzo());
			    		            	 pizzaSelezionata.setPrezzo(pizzaSelezionata.getPrezzo()+ (float)1);
			    		            	 aggiornaPrezzoTot();
			    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelezionata.getPrezzo());
			    		            	 PrezzoModifica.setText(String.valueOf(pizzaSelezionata.getPrezzo()));
			    		            } else{
			    		            	 System.out.println("Prezzo ModificaPizza selezionata PRIMA cambiamento: " + pizzaSelezionata.getPrezzo());
			    		            	 pizzaSelezionata.setPrezzo(pizzaSelezionata.getPrezzo()- (float)1);
			    		            	 aggiornaPrezzoTot();
			    		            	 PrezzoModifica.setText(String.valueOf(pizzaSelezionata.getPrezzo()));
			    		            	 System.out.println("Prezzo Pizza selezionata DOPO cambiamento: " + pizzaSelezionata.getPrezzo());
			    		            }
			    		        }
			    		    }
			    		};
			    		chkDoppio.setOnAction(dp);	 		    		
		    }
		    else {
		    	visibleGrid.setVisible(false);
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

	
	private float aggiornaPrezzoTot() {
	float prezzoTot=0;
	int max = listaPizze.size();
	System.out.println("Numero delle pizza nell'ordine e'" +max);
	for (int i = 0 ; i<max;i++ ) {
	    prezzoTot += listaPizze.get(i).getPrezzo();
	}
	System.out.println("Prezzo totale ordine e'" +prezzoTot);
	prezzoTotale.setText(String.valueOf(prezzoTot));
	return prezzoTot;
	}
	
	
	
	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Pizza.fxml"));
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene pizzaScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());
		return pizzaScene;
	}
}

