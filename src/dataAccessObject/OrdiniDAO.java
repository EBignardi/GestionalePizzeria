package dataAccessObject;


import java.sql.ResultSet;
import java.sql.SQLException;
import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ordine;


public class OrdiniDAO {

	public static void insertOrdine(String data, String Orario, float prezzo_totale,String nome_cliente,String indirizzo)throws SQLException, ClassNotFoundException {
		String sql = "insert into Ordine(data, orario,prezzo_totale,nome_cliente,indirizzo) values ('"+data+"','"+ Orario +"','"+ prezzo_totale +"','" + nome_cliente+ "','"+indirizzo +"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}

	public static void insertPrezzoUltimoOrdine(float prezzo_totale)throws SQLException, ClassNotFoundException {
		String sql = "UPDATE Ordine SET prezzo_totale = "+prezzo_totale+" WHERE id_ordine = (SELECT MAX(id_ordine) FROM Ordine)";
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
		String sql ="SELECT * from Ordine;";
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
//				ordine.setDate(rsSet.getDate("data"));
	//			ordine.setOrario(rsSet.getTime("orario"));
				ordine.setPrezzoTotale(rsSet.getFloat("prezzo_totale"));
				ordine.setNomeCliente(rsSet.getString("nome_cliente"));
				ordine.setIndirizzo(rsSet.getString("indirizzo"));
				ordineList.add(ordine);
				System.out.println("Leggendo gli ordini dal DB");
			}
			
			return ordineList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
}
