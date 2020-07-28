package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import dataAccessObject.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import manager.WindowsManager;

public class TitolareController implements Initializable {

	@FXML
	private Label userlbl;
	
	@FXML // fx:id="btn_logout"
	private Button btn_logout;
	
    @FXML // fx:id="chartVendite"
    private LineChart<String, Number> chartOrdini; // Value injected by FXMLLoader
    
    @FXML // fx:id="chartVendite"
    private LineChart<String, Number> chartVendite; // Value injected by FXMLLoader

    @FXML // fx:id="top3clienti"
    private PieChart top3clienti; // Value injected by FXMLLoader

    @FXML // fx:id="top3clienti"
    private PieChart top3pizze; // Value injected by FXMLLoader
    
    @FXML // fx:id="TitolareBackHome"
	private Button TitolareBackHome; // Value injected by FXMLLoader
    
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> nomeMesi = FXCollections.observableArrayList();
    
    public Scene start() throws Exception {		
		Parent par = FXMLLoader.load(getClass().getResource("/view/Titolare.fxml"));
		
		//settaggio fullScreen
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene homeScene = new Scene(par, screenBounds.getWidth(), screenBounds.getHeight());
		
		return homeScene;
	}
    
    
    @FXML
    void Logout(ActionEvent event) throws Exception {
    	System.out.println("Ritorno a finestra home");
    	WindowsManager.start();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userlbl.setText("Welcome chef");
		
		setGraficoOrdini();
		setGraficoVendite();
		setTop3Clienti();
		setTop3Pizze();
	}

	public void setGraficoOrdini() {
		// Get an array with the Italian month names
		String[] mesi = DateFormatSymbols.getInstance(Locale.ITALIAN).getMonths();
		// Convert it to a list and add it to our ObservableList of months.
		nomeMesi.addAll(Arrays.asList(mesi));

		//array ordinato che mi dice il numero di ordini per mese		
		int[] ordiniMese = new int[12];
		
		//estrazione dei dati dal DataBase
		try {
			ordiniMese = ClienteDAO.ordiniPerMese();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nella copiatura array ordiniMese");
			e.printStackTrace();
		}

		//caricamento dati nel grafico relativo agli Ordini
		Series<String, Number> series = new XYChart.Series<String, Number>();

		for (int i = 0; i < 12; i++) {
			series.getData().add(new XYChart.Data<String, Number>(nomeMesi.get(i), ordiniMese[i]));
		}

		series.setName("Numero ordini mensili");
		chartOrdini.getData().add(series);
	}
	
	
	public void setGraficoVendite() {
		// Get an array with the Italian month names
		String[] mesi = DateFormatSymbols.getInstance(Locale.ITALIAN).getMonths();
		// Convert it to a list and add it to our ObservableList of months.
		nomeMesi.addAll(Arrays.asList(mesi));

		//array ordinato che mi dice il fatturato per mese		
		float[] fatturatoMese = new float[12];
		
		try {
			fatturatoMese = ClienteDAO.fatturatoPerMese();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nella copiatura array fatturatoMese");
			e.printStackTrace();
		}

		//caricamento dati nel grafico relativo agli Ordini
		Series<String, Number> series = new XYChart.Series<String, Number>();

		for (int i = 0; i < 12; i++) {
			series.getData().add(new XYChart.Data<String, Number>(nomeMesi.get(i), fatturatoMese[i]));
		}

		series.setName("Fatturato mensile");
		chartVendite.getData().add(series);
	}
	
	public void setTop3Clienti() {
		
		//lista che restituisce i primi 3 clienti		
		List<String> topClienti = new ArrayList<String>();

		try {
			topClienti = ClienteDAO.topClienti();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nella copiatura Lista top Clienti");
			e.printStackTrace();
		}

		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                		new PieChart.Data(topClienti.get(0), 50),
                		new PieChart.Data(topClienti.get(1), 30),
                		new PieChart.Data(topClienti.get(2), 20)
                );
       
		top3clienti.setTitle("Top 3 Clienti");

		top3clienti.getData().addAll(pieChartData);
	}
	
	public void setTop3Pizze() {
		
		//lista che restituisce le prime 3 pizze
		List<String> topPizze = new ArrayList<String>();

		try {
			topPizze = ClienteDAO.topPizze();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nella copiatura Lista top Clienti");
			e.printStackTrace();
		}

		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data(topPizze.get(0), 50),
                new PieChart.Data(topPizze.get(1), 30),
                new PieChart.Data(topPizze.get(2), 20)
                );
       
		top3pizze.setTitle("Top 3 Pizze");
		top3pizze.getData().addAll(pieChartData);
	}
	
	
	 @FXML
	    void BackHomeT(ActionEvent event) throws Exception {
	    	System.out.println("Ritorno a finestra home");
	    	WindowsManager.start();
	    }
	
}
