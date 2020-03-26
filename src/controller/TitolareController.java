package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import dataAccessObject.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;

public class TitolareController implements Initializable {

	@FXML
	private Label userlbl;
	
    @FXML // fx:id="chartVendite"
    private LineChart<String, Number> chartVendite; // Value injected by FXMLLoader
    
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> nomeMesi = FXCollections.observableArrayList();
    
    private ObservableList<Integer> ordiniMese = FXCollections.observableArrayList();
    
	public Scene start() throws Exception {		
		Parent par = FXMLLoader.load(getClass().getResource("/view/Titolare.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userlbl.setText("Welcome Ciani");
		
		setGraficoOrdini();
		
		
	}

	public void setGraficoOrdini() {
		// Get an array with the Italian month names
		String[] mesi = DateFormatSymbols.getInstance(Locale.ITALIAN).getMonths();
		// Convert it to a list and add it to our ObservableList of months.
		nomeMesi.addAll(Arrays.asList(mesi));

		//array ordinato che mi dice il numero di ordini per mese		
		int[] ordiniMese = new int[12];
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
		chartVendite.getData().add(series);
	}
	
	public void setGrafico() {
		// Get an array with the Italian month names
		String[] mesi = DateFormatSymbols.getInstance(Locale.ITALIAN).getMonths();
		// Convert it to a list and add it to our ObservableList of months.
		nomeMesi.addAll(Arrays.asList(mesi));

		//array ordinato che mi dice il numero di ordini per mese		
		int[] ordiniMese = new int[12];
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
		chartVendite.getData().add(series);
	}
}
