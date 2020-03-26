package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Cliente;


public class ClienteDAO {
	public static void insertCliente(String nomeCliente, String telefono, String indirizzo, String civico, String data, String orario)throws SQLException, ClassNotFoundException {
		String sql = "insert into Cliente(nome, indirizzo, civico, telefono, data, orario) "
				+ "values ('"+ nomeCliente +"','"+ indirizzo +"','"+ civico +"','"+ telefono +"','"+ data +"','"+ orario +"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static int[] ordiniPerMese() throws SQLException, ClassNotFoundException {
		String sql = "SELECT count(*) as ordini_mensili FROM Cliente GROUP BY strftime('%m',data); ";
		try {
			DBUtil.dbExcecuteQuery(sql);
			ResultSet rsSet = DBUtil.dbExecute(sql);
			
			int[] ordiniMese = new int[12];
			int i = 0;
			
			while(rsSet.next()) {
					ordiniMese[i] = (rsSet.getInt("ordini_mensili"));
					i++;
				}
			
			return ordiniMese ;
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data " + e);
			e.printStackTrace();
			throw e;
		}

	}
	
	
	
	//Da implementare nel caso servissero
	/**
	public static void updateCliente(String nomeCliente, String idCliente) throws SQLException, ClassNotFoundException{
		String sql ="update Cliente set nomeCliente = '"+ nomeCliente +"' where idCliente = '"+ idCliente +"' ";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while updating the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void deleteClienteById(int idCliente) throws SQLException, ClassNotFoundException{
		String sql ="delete from Cliente where id = '"+ idCliente +"'";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while deleting the record "+e);
			e.printStackTrace();
			throw e;
		}
	}

	//REFRESH ALL
	public static ObservableList<Cliente> getAllRecords() throws SQLException, ClassNotFoundException{
		String sql ="select * from Cliente";
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Cliente> ClienteList =  getClienteObject(rsSet);
			return ClienteList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Cliente> getAllRecordsAggiorna(String txt) throws SQLException, ClassNotFoundException{
		String sql ="select * from Cliente where nomeCliente LIKE"+"'%"+ txt +"%';" ;
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Cliente> ClienteList =  getClienteObject(rsSet);
			return ClienteList;

		}catch(SQLException e){
			System.out.println("Error occured while get all the record updated "+e);
			e.printStackTrace();
			throw e;
		}
	}

	
	private static ObservableList<Cliente> getClienteObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
		try {
			ObservableList<Cliente> ClienteList = FXCollections.observableArrayList();
			while(rsSet.next()) {
				Cliente Cliente = new Cliente();
				Cliente.setNomeCliente(rsSet.getString("nomeCliente"));
				Cliente.setPrezzo(rsSet.getFloat("prezzo"));
				Cliente.setIngredienti(rsSet.getString("ingredienti"));
				ClienteList.add(Cliente);
			}
			
			return ClienteList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Cliente> searchCliente(String nomeCliente) throws SQLException,ClassNotFoundException{
		String sql = "select * from Cliente where nomeCliente = " + nomeCliente;
		try {
			ResultSet rsSet = DBUtil.dbExecute(sql);
			ObservableList<Cliente> ClienteListSearch =  getClienteObject(rsSet);
			System.out.println("Pizze ritornate " + ClienteListSearch);
			return ClienteListSearch;
		}
		catch(SQLException e) {
			System.out.println("Error occured while searching Cliente " + e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Cliente> searchIngredientiCliente(String nomeCliente) throws SQLException,ClassNotFoundException{
		String sql = "select ingredienti from Cliente where nomeCliente = " + nomeCliente;
		try {
			ResultSet rsSet = DBUtil.dbExecute(sql);
			ObservableList<Cliente> ClienteIngredientiSearch =  getClienteObject(rsSet);
			System.out.println("Ingredienti ritornati " + ClienteIngredientiSearch);
			return ClienteIngredientiSearch;
		}
		catch(SQLException e) {
			System.out.println("Error occured while searching Ingredienti Cliente " + e);
			e.printStackTrace();
			throw e;
		}
	}
	**/
}
