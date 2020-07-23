package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ordine;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalTime;

public class OrdiniDAO {

	public static void insertOrdine(String data, String Orario, int prezzo_totale)throws SQLException, ClassNotFoundException {
		String sql = "insert into Ordine(data, orario, prezzo_totale) values ('"+data+"','"+ Orario +"','" + prezzo_totale+"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public static ObservableList<Ordine> getAllRecords() throws SQLException, ClassNotFoundException{
		String sql ="select * from Ordine";
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Ordine> ordineList =  getOrdineObject(rsSet);
			return ordineList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	private static ObservableList<Ordine> getOrdineObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
		try {
			ObservableList<Ordine> ordineList = FXCollections.observableArrayList();
			while(rsSet.next()) {
				Ordine ordine = new Ordine();
				Date date = rsSet.getDate("data");
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant  instant = date.toInstant();
				
				ordine.setDate(instant.atZone(defaultZoneId).toLocalDate());
				ordine.setOrario.toLocalTime(rsSet.getTime("ora"));
				ordineList.add(ordine);
			}
			
			return ordineList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
}
