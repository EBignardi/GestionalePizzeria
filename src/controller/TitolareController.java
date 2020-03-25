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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class TitolareController implements Initializable {

	@FXML
	private Label userlbl;
	
    @FXML // fx:id="chartVendite"
    private LineChart<String, Integer> chartVendite; // Value injected by FXMLLoader
    
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    
	public Scene start() throws Exception {
		//array ordinato che mi dice il numero di ordini per mese
		System.out.println("Clienti per mese: " + ClienteDAO.ordiniPerMese());
		
		Parent par = FXMLLoader.load(getClass().getResource("/view/Titolare.fxml"));
		Scene homeScene = new Scene(par);
		return homeScene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		// Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));
        
        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(monthNames);
        
	}
	
	/**
	//metodo per popolare il grafico
    public void setVenditeData() {
        // Count the number of client having their order in a specific month.
        int[] monthCounter = new int[12];
        int ordiniMese = 0;
       
        
        for (String c: monthResultList) {
            ordiniMese += 1;    // int month = p.getBirthday().getMonthValue() - 1;
        	monthCounter[ordiniMese]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        chartVendite.getData().add(series);
    }
   */
	
	public void getUsername(String username) {
		// TODO Auto-generated method stub
		userlbl.setText(username);
	}
}
