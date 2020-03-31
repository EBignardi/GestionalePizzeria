package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;

public class TitolareController implements Initializable {

	@FXML
	private Label userlbl;
	
    @FXML // fx:id="chartVendite"
    private LineChart<String, Number> chartOrdini; // Value injected by FXMLLoader
    
    @FXML // fx:id="chartVendite"
    private LineChart<String, Number> chartVendite; // Value injected by FXMLLoader

    @FXML // fx:id="top3clienti"
    private PieChart top3clienti; // Value injected by FXMLLoader

    @FXML // fx:id="top3clienti"
    private PieChart top3pizze; // Value injected by FXMLLoader
    
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> nomeMesi = FXCollections.observableArrayList();
    
    public Scene start() throws Exception {		
		Parent par = FXMLLoader.load(getClass().getResource("/view/Titolare.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userlbl.setText("Welcome Ciani");
		
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

		//array ordinato che mi dice il numero di ordini per mese		
		int[] fatturatoMese = {100, 50, 200, 300, 150, 250, 400, 650, 200, 300, 150, 250};
		
		//estrazione dei dati dal DataBase
		/*try {
			fatturatoMese = ;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nella copiatura array ordiniMese");
			e.printStackTrace();
		}*/

		//caricamento dati nel grafico relativo agli Ordini
		Series<String, Number> series = new XYChart.Series<String, Number>();

		for (int i = 0; i < 12; i++) {
			series.getData().add(new XYChart.Data<String, Number>(nomeMesi.get(i), fatturatoMese[i]));
		}

		series.setName("Fatturato mensile");
		chartVendite.getData().add(series);
	}
	
	public void setTop3Clienti() {
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Neri", 50),
                new PieChart.Data("Grenzi", 30),
                new PieChart.Data("Panarotto", 20)
                );
       
		top3clienti.setTitle("Top 3 Clienti");

		top3clienti.getData().addAll(pieChartData);
	}

	public void setTop3Pizze() {
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Salsiccia", 40),
                new PieChart.Data("Diavola", 37),
                new PieChart.Data("4 Stagioni", 23)
                );
       
		top3pizze.setTitle("Top 3 Pizze");

		top3pizze.getData().addAll(pieChartData);
	}
	
}
