package dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class OrdineDAO {
	public static void insertOrdine(String nomePizza, Integer quantita)throws SQLException, ClassNotFoundException {
		String sql = "insert into Ordine(pizza,quantita) values ('"+nomePizza+"','"+quantita+"')";
		try {
			DBUtil.dbExcecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception occur while inserting the data "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	public static void updateOrdine(int id, String email) throws SQLException, ClassNotFoundException{
		String sql ="update Ordine set email = '"+email+"' where id = '"+id+"' ";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while updating the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	public static void deleteOrdineById(int id) throws SQLException, ClassNotFoundException{
		String sql ="delete from Ordine where id = '"+id+"'";
		try {
			DBUtil.dbExcecuteQuery(sql);

		}catch(SQLException e){
			System.out.println("Error occured while deleting the record "+e);
			e.printStackTrace();
			throw e;
		}
	}

	//REFRESH ALL
	public static ObservableList<Ordine> getAllRecords() throws SQLException, ClassNotFoundException{
		String sql ="select * from Ordine";
		try {
			ResultSet rsSet =  DBUtil.dbExecute(sql);
			ObservableList<Ordine> empList =  getOrdineObject(rsSet);
			return empList;

		}catch(SQLException e){
			System.out.println("Error occured while deleting the record "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	private static ObservableList<Ordine> getOrdineObject(ResultSet rsSet) throws SQLException,ClassNotFoundException {
		try {
			ObservableList<Ordine> empList = FXCollections.observableArrayList();
			while(rsSet.next()) {
				Ordine emp = new Ordine();
				emp.setEmpId(rsSet.getInt("id"));
				emp.setEmpName(rsSet.getString("first_name"));
				emp.setEmpLastName(rsSet.getString("last_name"));
				emp.setEmpEmail(rsSet.getString("email"));
				empList.add(emp);
			}
			return empList;
		}catch(SQLException e) {
			System.out.println("Error occured while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Ordine> searchOrdine(String OrdineID) throws SQLException,ClassNotFoundException{
		String sql = "select * from Ordine where id = "+OrdineID;
		try {
			ResultSet rsSet = DBUtil.dbExecute(sql);
			ObservableList<Ordine> empListSearch =  getOrdineObject(rsSet);
			return empListSearch;
		}
		catch(SQLException e) {
			System.out.println("Error occured while searching Ordine "+e);
			e.printStackTrace();
			throw e;
		}
	}
	*/
}

