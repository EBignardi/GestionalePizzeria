package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dataAccessObject.PizzaDAO;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Pizza;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class PizzaController {
	
    @FXML // fx:id="txtCercaPizza"
    private TextField txtCercaPizza; // Value injected by FXMLLoader

    @FXML // fx:id="btnModifica"
    private Button btnModifica; // Value injected by FXMLLoader

    @FXML // fx:id="GroupImpasto"
    private ToggleGroup GroupImpasto; // Value injected by FXMLLoader

    @FXML // fx:id="colPizza"
    private TableColumn<Pizza, String> colPizza; // Value injected by FXMLLoader

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

    @FXML // fx:id="colPrezzo"
    private TableColumn<Pizza, Float> colPrezzo; // Value injected by FXMLLoader

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
	void btnAggiungiPizzaAction(ActionEvent event) throws ClassNotFoundException, SQLException {
		System.out.println("Aggiunta Pizza");
		Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		if (pizzaSelezionata == null) {
			System.out.println("Nessuna Pizza selezionata");
		} else {
			
			//devo aggiungedere il metodo per vedere se ho cambiato qualche ingredienti, es flag = 1
			
			StringProperty nomePizzaSelezionata = pizzaSelezionata.getNomePizzaProperty();
			FloatProperty prezzoPizzaSelezionata = pizzaSelezionata.getPrezzoProperty();
			System.out.println("Nome Pizza selezionata = " + nomePizzaSelezionata.get());
			System.out.println("Prezzo Pizza selezionata = " + prezzoPizzaSelezionata.get());
			
			Pizza pizzaSelected = new Pizza(pizzaSelezionata.getNomePizzaProperty(), pizzaSelezionata.getPrezzoProperty(), pizzaSelezionata.getIngredientiProperty());
			tabOrdine.getItems().add(pizzaSelected);
		}
		
		
	}
	
	public void clearChkRdo() { 
		rdoPomodoroNo.setSelected(true);
		rdoMozzarellaNo.setSelected(true);
		
		chkProsciuttoCotto.setSelected(false);
		chkWustrler.setSelected(false);
		chkTuaMamma.setSelected(false);
		chkDiavola.setSelected(false);  
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
		
		colPizza.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		
		colPizzaSelezione.setCellValueFactory(cellData -> cellData.getValue().getNomePizzaProperty());
		colPrezzoSelezione.setCellValueFactory(cellData -> cellData.getValue().getPrezzoProperty().asObject());
		ObservableList<Pizza> pizzaList = PizzaDAO.getAllRecords();
		populateTable(pizzaList);
		
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
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
        { 
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) 
            { 
  
                RadioButton rb = (RadioButton)tg.getSelectedToggle(); 
  
                if (rb != null) { 
                    String s = rb.getText(); 
  
                    // change the label 
                    l2.setText(s + " selected"); 
                } 
            } 
        })
		*/
	
		
		tabCercaPizza.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	System.out.println("Selezione Pizza Valida");
		    	
		    	//Qui devo selezionare i rdoButton in base alla pizza selezionata
		    	//creo un metodo per selezionare gli ingredienti in base al nome della pizza
		    	Pizza pizzaSelezionata = tabCercaPizza.getSelectionModel().getSelectedItem();
		    	Pizza pizzaSelected = new Pizza(pizzaSelezionata.getNomePizzaProperty(), pizzaSelezionata.getPrezzoProperty(), 
		    			pizzaSelezionata.getIngredientiProperty());
		    	String ingredienti = pizzaSelected.getIngredienti();
		    	clearChkRdo();
		    	//ingredienti = stringa che contiene gli ingredienti, separati da un '/'
		    	System.out.println(ingredienti);
		    	
		    	//ricavo i singoli ingredienti
		    	Scanner s = new Scanner(ingredienti);
		    	s.useDelimiter("/");
		    	
		    	 while(s.hasNext()){
		    		 String ingrediente = s.next();
		    		 
		    		 if (ingrediente.equals("Mozzarella")) 
		    			 rdoMozzarellaSì.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Pomodoro")) 
		    			 rdoPomodoroSì.setSelected(true);
		    		 
		    		 if (ingrediente.equals("Diavola")) 
		    			 chkDiavola.setSelected(true);
		    		 
		    		 
		    		 if (ingrediente.equals("TuaMamma")) 
		    			 chkTuaMamma.setSelected(true);
		    		
		    		 
		    		 if (ingrediente.equals("Wustrler"))
		    			 chkWustrler.setSelected(true);
		    		 
		    		 
		    		 if (ingrediente.equals("ProsciuttoCotto"))
		    			 chkProsciuttoCotto.setSelected(true);
		    		
		    		 
		    		 System.out.println(ingrediente);
		    	 }   
		    	 
		    	 s.close();
		    }
		    
		    else {
		    	System.out.println("Selezione Pizza NON Valida");
		    }
		    		 
		});
		
	}
	

	private void populateTable(ObservableList<Pizza> pizzaList) {
		tabCercaPizza.setItems(pizzaList);
	}

	public Scene start() throws Exception {
		Parent par = FXMLLoader.load(getClass().getResource("/view/Pizza.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
}
